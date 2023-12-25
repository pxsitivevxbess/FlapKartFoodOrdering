package DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import Model.Order;
import Model.Rating;
import Model.Restaurant;
import Model.User;
import Utils.IDGenerator;

public class UserDAO {

	private static UserDAO userDAO = null;
	//Unorderd_set equivalent in Java -> HashSet
	private HashMap<Integer, User> usersList = new HashMap<>();
	private HashMap<String, Restaurant> restaurantList = new HashMap<>();
	private HashMap<String, ArrayList<Rating>> ratingRestaurantWise = new HashMap<>();
	private HashMap<Integer, ArrayList<Order>> userWiseOrders = new HashMap<>();
	private User loggedInUser = null;
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
		return userToLogin;
	}
	public Restaurant registerRestaurant(String name, String servingAreas, String dish, Integer price, Integer quantity)
	{
		int restaurantId = IDGenerator.getId();
		Restaurant newRestaurant = new Restaurant(restaurantId, name, restaurantId, servingAreas, restaurantId, dish);
		restaurantList.putIfAbsent(name, newRestaurant);
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
	}
}
