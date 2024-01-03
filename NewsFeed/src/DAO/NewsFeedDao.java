package DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import Model.Comment;
import Model.Post;
import Model.User;
import Utils.IDGenerator;

public class NewsFeedDao {

	private static NewsFeedDao newsFeedDao = null;
	private HashMap<String, User> usersDb = new HashMap<>();  //<UserName, User>
	private HashMap<Integer, Post> postDb = new HashMap<>() ; //<PostId, Post>
	private User currentLoggedInUser = null;
	public static NewsFeedDao getInstance()
	{
		if(newsFeedDao==null)
		{
			newsFeedDao = new NewsFeedDao();
		}
		return newsFeedDao;
	}
	public User signUp(String name)
	{
	  User newUser = new User(name);
	  Integer userId = IDGenerator.generateId();
	  newUser.setUserId(userId);
	  usersDb.put(name, newUser);
	  return newUser;
	  
	}
	public User login(String name)
	{
		User userObj = usersDb.get(name);
		if(userObj==null)
		{
			System.out.println("User not found can't login");
			return null;
		}
		currentLoggedInUser = userObj;
		System.out.println("Current Logged In User"+currentLoggedInUser);
		return currentLoggedInUser;
	}
	public Post post(String postContent)
	{
		System.out.println("Number of post before new post"+postDb.size());
		Post newPost = new Post();
		Integer postId = IDGenerator.generateId();
		Long currentTimeStamp = System.currentTimeMillis();
		newPost.setPostId(postId);
		newPost.setUserId(currentLoggedInUser.getUserId());
		newPost.setContent(postContent);
		newPost.setTimeStamp(currentTimeStamp);
		postDb.put(postId, newPost);
		System.out.println("Number of post after new post"+postDb.size());
		return newPost;
	}
	public Post upVotePostOrDownVote(Integer postId, Boolean isUpvote)
	{
		Post postToUpvoteOrDownVote = postDb.get(postId);
		
		if(postToUpvoteOrDownVote==null)
		{
			System.out.println("Post you trying to Upvote does not exist");
			return null;
		}
		else {
			System.out.println("Post before Upvote/Downvote"+postToUpvoteOrDownVote.getUpvotesCount());
			if(isUpvote) {
				postToUpvoteOrDownVote.setUpvotesCount(postToUpvoteOrDownVote.getUpvotesCount()+1);
				
			}
			else {
				postToUpvoteOrDownVote.setDownVotesCount(postToUpvoteOrDownVote.getDownVotesCount()+1);
			}
			postDb.put(postId, postToUpvoteOrDownVote);
			System.out.println("Post after Upvote/Downvote"+postDb.get(postId));
			return postToUpvoteOrDownVote;
		}
	}
	public Post reply(Integer postId, String comment) {
        Post postOnWhichComment = postDb.get(postId);
		
		if(postOnWhichComment==null)
		{
			System.out.println("Post you trying to Upvote does not exist");
			return null;
		}
		else {
			System.out.println("Number of comments before"+postOnWhichComment.getComments().size());
			Comment commentObj = new Comment();
			commentObj.setPostId(postId);
			commentObj.setUserId(currentLoggedInUser.getUserId());
			Long currentTimeStamp = System.currentTimeMillis();
			commentObj.setTimeStamp(currentTimeStamp);
			postOnWhichComment.getComments().add(commentObj);
			postDb.put(postId, postOnWhichComment);
			System.out.println("Number of comments after"+postDb.get(postId).getComments().size());
			return postOnWhichComment;
		}
	}
	public User follow(String name)
	{
		User userToFollow = usersDb.get(name);
		if(userToFollow==null)
		{
			System.out.println("User to follow does not exit");
			return null;
		}
		else 
		{
			//Integer userId = currentLoggedInUser.getUserId();
			System.out.println("Number of users followed by current logged user before"+currentLoggedInUser.getFollowings().size());
			currentLoggedInUser.getFollowings().add(userToFollow);
			System.out.println("Number of users followed by current logged after 1"+currentLoggedInUser.getFollowings());

			usersDb.put(currentLoggedInUser.getName(), currentLoggedInUser);
			System.out.println("Number of users followed by current logged after 2"+usersDb.get(currentLoggedInUser.getName()));

			System.out.println("Number of users followed by current logged user after"+usersDb.get(currentLoggedInUser.getName()).getFollowings().size());
            return currentLoggedInUser;
		}
	}
	public void showNewsFeed()
	{
		//HashSet<Integer> seenPost = new HashSet<>();
		ArrayList<Integer> sortedPostId = new ArrayList<>();
		for(Map.Entry<Integer, Post> entry: postDb.entrySet())
		{
			Integer postId = entry.getKey();
			Post post = entry.getValue();
			sortedPostId.add(postId);
		}
		System.out.println("########DEBUG BEFORE SORT:"+sortedPostId);
		Collections.sort(sortedPostId, new 	Comparator<Integer>() {
			@Override
//			If compare returns a negative value, it often implies that the first object should come before the second object in the sorted order. This can be considered an "increasing" order, as you are moving from smaller to larger values.
//
//			If compare returns a positive value, it often implies that the first object should come after the second object in the sorted order. This can be considered a "decreasing" order, as you are moving from larger to smaller values.
//
//			If compare returns zero, it means that the two objects are considered equal in terms of their order, and their relative positions may not change.
        	public int compare(Integer postId1, Integer postId2)
			{
				Post postObj1 = postDb.get(postId1);
				Post postObj2 = postDb.get(postId2);
				Boolean post1Follow = false;
				Boolean post2Follow = false;
				for(Integer i=0;i<currentLoggedInUser.getFollowings().size();i++)
				{
					System.out.println("current following:"+currentLoggedInUser.getFollowings().get(i).getUserId()+postId1+postId2);
					if(currentLoggedInUser.getFollowings().get(i).getUserId()==postObj1.getUserId())
					{
						post1Follow = true;
					}
					if(currentLoggedInUser.getFollowings().get(i).getUserId()==postObj2.getUserId())
					{
						post2Follow = true;
					}
				}
				System.out.println("##########DEBUG"+post1Follow+post2Follow);
				System.out.println("##########DEBUG"+currentLoggedInUser.getFollowings());

				if(post1Follow!= post2Follow)
				{
					if(post1Follow)
					{
						return -1;
					}
					else {
						return 1; //second post should come first
					}
				}
				else
				{
					if(postObj1.getUpvotesCount()-postObj1.getDownVotesCount()!=postObj2.getUpvotesCount()-postObj2.getDownVotesCount()) {
						System.out.println("####DEBUG since both post by following");
					    return postObj1.getUpvotesCount()-postObj1.getDownVotesCount()>postObj2.getUpvotesCount()-postObj2.getDownVotesCount()==true?-1:1;
//                      Alternatively you can use Integer.compare					    
//						return Integer.compare(postObj2.getUpvotesCount() - postObj2.getDownVotesCount(),
//	                            postObj1.getUpvotesCount() - postObj1.getDownVotesCount());
					}
					else if(postObj1.getComments().size()!=postObj2.getComments().size())
					{
						System.out.println("Count of comments used for sorting"+postObj1.getComments().size()+"-"+postObj2.getComments().size());
						return postObj1.getComments().size()>postObj2.getComments().size()?-1:1;
					}
					else {
						return postObj1.getTimeStamp()>postObj2.getTimeStamp()?-1:1;
						
					}
					
				}
			}
		});
		System.out.println("########DEBUG AFTER SORTING"+sortedPostId);
		for(int i=0;i<sortedPostId.size();i++)
		{
		   Integer currPostId = sortedPostId.get(i);
		   Post currPost = postDb.get(currPostId);
		   System.out.println("Post:"+currPost.getContent());
		}
		
	}
	
}
