package Service;

import DAO.NewsFeedDao;
import Model.Post;

public class PostService {
	private static PostService postService = null;
	private NewsFeedDao newsFeedDao = NewsFeedDao.getInstance();
	public static PostService getInstance()
	{
		if(postService==null)
		{
			postService =  new PostService();
		}
		return postService;
	}
	public Post post(String postContent)
	{
		return newsFeedDao.post(postContent);
	}
	public Post upVotePostOrDownVote(Integer postId, Boolean isUpvote)
	{
		return newsFeedDao.upVotePostOrDownVote(postId, isUpvote);
	}
	public Post reply(Integer postId, String comment)
	{
	    return newsFeedDao.reply(postId, comment);
	}


}
