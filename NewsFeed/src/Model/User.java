package Model;

import java.util.ArrayList;

public class User {
	private String name;
	private Integer userId;
	private ArrayList<User> followings= new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public ArrayList<User> getFollowings() {
		return followings;
	}
	public void setFollowings(ArrayList<User> followings) {
		this.followings = followings;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", userId=" + userId + ", followings=" + followings + "]";
	}
	public User(String name) {
		super();
		this.name = name;
	}

}
