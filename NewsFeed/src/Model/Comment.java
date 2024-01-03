package Model;

import java.util.ArrayList;

public class Comment {
	private Integer postId;
	private Integer userId; //User id of commenter
	private Long timeStamp;
	private ArrayList<Comment> comments = new ArrayList<>();
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Comment [postId=" + postId + ", userId=" + userId + ", timeStamp=" + timeStamp + ", comments="
				+ comments + "]";
	}
	

}
