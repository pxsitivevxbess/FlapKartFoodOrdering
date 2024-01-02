package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import Constants.Gender;

public class User {
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", locality=" + locality
				+ ", orderHistory=" + orderHistory + ", geneder=" + geneder + ", restaurant=" + restaurant + ", orders="
				+ orders + "]";
	}

	private int userId;
	private String name;
	private Integer mobileNumber;
	private String locality;
	private HashMap<String, Integer> orderHistory = new HashMap<>();//Restaurant Name, Quantity
	private Gender geneder;
	private List<Restaurant> restaurant = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	
	public User(int userId, String name, Integer mobileNumber, String locality, String gender) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.locality = locality;
		this.geneder = gender=="M"?Gender.MALE:gender=="F"?Gender.FEMALE:Gender.OTHERS;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public HashMap<String, Integer> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(HashMap<String, Integer> orderHistory) {
		this.orderHistory = orderHistory;
	}

	public Gender getGeneder() {
		return geneder;
	}

	public void setGeneder(Gender geneder) {
		this.geneder = geneder;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
//	public User(String name, Integer mobileNumber, String locality)
//	{
//		try {
//		this.userId = UUID.randomUUID();
//		this.name = name;
//		this.mobileNumber = mobileNumber;
//		this.locality = locality;
//		this.orderHistory = new HashMap<String, Integer>();
//		}catch( Exception error)
//		{
//			System.out.println(error);
//			throw error;
//		}
//	}
	
}
