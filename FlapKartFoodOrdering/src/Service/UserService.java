package Service;

import java.util.ArrayList;

import DAO.UserDAO;
import Model.Order;
import Model.User;

public class UserService {
	private static UserService userService = null;
	private UserDAO userDAO = UserDAO.getInstance();
	public static UserService getInstance()
	{
		if(userService==null)
		{
			userService = new UserService();
		}
		return userService;
	}
	
	public User register_user(String name, String gender, Integer mobileNumber, String locality)
	{
		if(mobileNumber<0|| mobileNumber==null)
		{
			return null;
		}
		if(locality==null || locality =="")
		{
			return null;
		}
		 return userDAO.registerUser(name, gender, mobileNumber, locality);
		
	}
	public User login_user(Integer mobileNumber)
	{
		if(mobileNumber<0|| mobileNumber==null)
		{
			return null;
		}
		return userDAO.loginUser(mobileNumber);
	}
	public ArrayList<Order> order_history()
	{
		ArrayList<Order> orderHistory =userDAO.orderHistory();
		System.out.println("Number of order placed by user"+orderHistory.size());
		System.out.println("First order place by user"+orderHistory.get(0));
		return orderHistory;

	}

}
