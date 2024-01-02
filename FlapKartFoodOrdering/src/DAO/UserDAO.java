package DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import Model.Order;
import Model.Rating;
import Model.Restaurant;
import Model.User;
import Utils.IDGenerator;

public class UserDAO {

	private static UserDAO userDAO = null;
	//Unorderd_set equivalent in Java -> HashSet
	//Unordered_map equivalent in Java -> HashMap
	private HashMap<Integer, User> usersList = new HashMap<>();//<MobileNumber, User Obj>
	private HashMap<String, Restaurant> restaurantList = new HashMap<>(); //<Name of Restaurant,Restaurant Obj>
	private HashMap<String, ArrayList<Rating>> ratingRestaurantWise = new HashMap<>();//<Restaurant name, rating>
	private HashMap<Integer, ArrayList<Order>> userWiseOrders = new HashMap<>(); //<UserId, [orders]>
	private User loggedInUser = null;  // In Memory variable for currently logged in user
	public static UserDAO getInstance() {
		if(userDAO==null)
		{
			userDAO = new UserDAO();
		}
		return userDAO;
	}
	public User registerUser(String name, String gender, Integer mobileNumber, String locality)
	{
		int userId = IDGenerator.getId();
		User newUser = new User(userId, name, mobileNumber, locality,gender);
		usersList.putIfAbsent(mobileNumber, newUser);
		return newUser;
	}
	public User loginUser(int mobileNumber) {
		User userToLogin = usersList.get(mobileNumber);
		if(userToLogin!= null)
		{
			loggedInUser = userToLogin;
		}
		System.out.println("Logged in user"+loggedInUser);
		return userToLogin;
	}
	public Restaurant registerRestaurant(String name, String servingAreas, String dish, Integer price, Integer quantity)
	{
		int restaurantId = IDGenerator.getId();
		Restaurant newRestaurant = new Restaurant(restaurantId, name,quantity,servingAreas, price, dish);
		restaurantList.putIfAbsent(name, newRestaurant);
		System.out.println("Number of restaurant"+restaurantList.size());
		return newRestaurant;
	}
	public Integer updateQuantity(String restaurantName, Integer quantity) {
		Restaurant restaurant = restaurantList.get(restaurantName);
		if(restaurant != null) {
			restaurant.setQuantity(quantity);
			restaurantList.putIfAbsent(restaurantName, restaurant);
			return quantity;
		}
		return -1;
	}
	public Rating createReview(String restaurantName, Integer score, String comment)
	{
		Restaurant restaurant = restaurantList.get(restaurantName);
		if(restaurant != null)
		{
			Integer ratingId = IDGenerator.getId();
			Rating newRating = new Rating(ratingId,loggedInUser.getUserId(),restaurant.getId(), score, comment);
			int ratingCount =  restaurant.getRatingCount();
			float rating = restaurant.getRating();
			restaurant.setRating((ratingCount*rating+score)/(ratingCount+1));
			restaurant.setRatingCount(ratingCount+1);
			restaurantList.putIfAbsent(restaurantName, restaurant);
			if (ratingRestaurantWise.containsKey(restaurantName)) {
			    // If the key exists, get the ArrayList and add the new Rating
			    ratingRestaurantWise.get(restaurantName).add(newRating);
			} else {
			    // If the key doesn't exist, create a new ArrayList, add the new Rating, and put it in the HashMap
			    ArrayList<Rating> newRatingList = new ArrayList<>();
			    newRatingList.add(newRating);
			    ratingRestaurantWise.put(restaurantName, newRatingList);
			}
			System.out.println("Average rating of restaurant"+restaurant.getRating());
			System.out.println("Number of rating received "+ratingRestaurantWise.get(restaurantName).size());
			return newRating;
		}
		
		return null;
	}
	
	public List<Restaurant> showRestaurant(String parameter){
        List<Restaurant> sortedRestaurants = new ArrayList<>(restaurantList.values());
        if(parameter =="price") {
        Collections.sort(sortedRestaurants, Comparator.comparingInt(Restaurant::getPrice));
        }
        else {
        	Collections.sort(sortedRestaurants, Comparator.comparingDouble(Restaurant::getRating));
        }
        System.out.println("Top of show restaurant"+sortedRestaurants.get(0));
        return sortedRestaurants;

	}
	public Order placeOrder(String restaurantName, Integer quantity)
	{
		Restaurant restaurant = restaurantList.get(restaurantName);
		if(restaurant.getQuantity()<quantity)
		{
			return null;
		}
		Order order = new Order();
		order.setUserId(loggedInUser.getUserId());
		order.setQuantity(quantity);
		order.setRestaurantId(restaurantList.get(restaurantName).getId());
		order.setId(IDGenerator.getId());
		System.out.println("Current available quantity of restaurant"+ restaurant.getQuantity());
		System.out.println("quantity requested"+ quantity);
		restaurant.setQuantity(restaurant.getQuantity()-quantity);
		System.out.println("New available quantity of restaurant"+ restaurant.getQuantity());
		restaurantList.put(restaurantName, restaurant);
		ArrayList<Order> orderHistory =userWiseOrders.get(loggedInUser.getUserId())!=null?userWiseOrders.get(loggedInUser.getUserId()):new ArrayList<Order>();
		orderHistory.add(order);
		userWiseOrders.put(loggedInUser.getUserId(), orderHistory);
		System.out.println("Number of orders placed by user"+userWiseOrders.get(loggedInUser.getUserId()).size());
		return order;
		
	}
	public ArrayList<Order> orderHistory()
	{
		 return Optional.ofNullable(userWiseOrders.get(loggedInUser.getUserId()))
                 .orElse(new ArrayList<>());
	}
}
