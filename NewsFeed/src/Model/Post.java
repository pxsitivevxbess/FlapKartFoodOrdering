package Model;

import java.util.ArrayList;

public class Post {
	private Integer postId;
	private String content;
	private Integer userId;
	private Integer upvotesCount= 0;
	private Integer downVotesCount = 0;
	private Long timeStamp;
	private ArrayList<Comment> comments = new ArrayList<>();
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", userId=" + userId + ", upvotesCount="
				+ upvotesCount + ", downVotesCount=" + downVotesCount + ", timeStamp=" + timeStamp + ", comments="
				+ comments + "]";
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUpvotesCount() {
		return upvotesCount;
	}
	public void setUpvotesCount(Integer upvotesCount) {
		this.upvotesCount = upvotesCount;
	}
	public Integer getDownVotesCount() {
		return downVotesCount;
	}
	public void setDownVotesCount(Integer downVotesCount) {
		this.downVotesCount = downVotesCount;
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

}
