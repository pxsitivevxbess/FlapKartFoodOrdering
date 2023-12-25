package Service;

import DAO.UserDAO;
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

}
