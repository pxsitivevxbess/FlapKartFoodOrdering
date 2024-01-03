package Service;

import DAO.NewsFeedDao;
import Model.User;
import Utils.IDGenerator;

public class UserService {
	private static UserService userService= null;
	private NewsFeedDao newsFeedDao = NewsFeedDao.getInstance();
	public static UserService getInstance()
	{
		if(userService==null)
		{
			userService =  new UserService();
		}
		return userService;
	}
	public User signUp(String name)
	{
	 return newsFeedDao.signUp(name);
	  
	}
	public User login(String name)
	{
		return newsFeedDao.login(name);
	}
	public User follow(String name)
	{
		return newsFeedDao.follow(name);
	}
	public void showNewsFeed()
	{
		newsFeedDao.showNewsFeed();
	}
	

}
