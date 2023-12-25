package Model;

public class Rating {
	private int id;
	private int userId;
	private int restaurantId;
	private int rating;
	private String comment;
	public Rating(int id,int userId, int restaurantId, int rating, String comment) {
		super();
		this.id = id;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.rating = rating;
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
