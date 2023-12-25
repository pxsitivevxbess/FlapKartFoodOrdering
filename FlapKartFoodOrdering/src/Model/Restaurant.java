package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
	private int id;
	private String name; 
	private int quantity;
	private List<String> serviceableAreas = new ArrayList<>();
	private int price;
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	private String dish;
	private Float rating;
	private int ratingCount;
	private List<Rating> reviews = new ArrayList<>();
	
	public Restaurant(int id,String name, int quantity, String areas, int price, String dish )
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.dish = dish;
		this.price = price;
		this.rating = (float) 0;
		this.ratingCount = 0;
		serviceableAreas = Arrays.asList(areas.split("/"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<String> getServiceableAreas() {
		return serviceableAreas;
	}

	public void setServiceableAreas(List<String> serviceableAreas) {
		this.serviceableAreas = serviceableAreas;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
		

}
