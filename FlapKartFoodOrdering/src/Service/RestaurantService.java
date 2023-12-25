package Service;

import java.util.List;

import DAO.UserDAO;
import Model.Rating;
import Model.Restaurant;

public class RestaurantService {
	private static RestaurantService restaurantService = null;
	private UserDAO userDAO =  UserDAO.getInstance();
	public static RestaurantService getInstance()
	{
		if(restaurantService==null)
		{
			restaurantService = new RestaurantService();
		}
		return restaurantService;
	}
	public Restaurant register_restaurant(String name, String servingAreas, String dish, Integer price, Integer quantity)
	{
		return userDAO.registerRestaurant(name, servingAreas, dish, price, quantity);
		
	}
	public int update_quantity(String name, int quantity)
	{
	  return userDAO.updateQuantity(name, quantity);	
	}
	public Rating create_review(String restaurantName,int score, String comment )
	{
		return userDAO.createReview(restaurantName, score, comment);
		
	}

	public List<Restaurant> show_restaurant(String parameter)
	{
		return userDAO.showRestaurant(parameter);
	}
}
