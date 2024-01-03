package Driver;

import Service.PostService;
import Service.UserService;

public class Main {
	
	//signup name
	//login name 
	//post string
    //upvote postId
	//downvote postid
	//reply postid string
	//follow name
	//shownewsfeed
	public static void main(String[] args) {
	UserService userService = UserService.getInstance();
	PostService postService = PostService.getInstance();
	userService.signUp("lucious");
	userService.signUp("albus");
	userService.signUp("tom");
	userService.login("tom");
	postService.post("I am going to be the darkest dark wizard of all time");
	postService.post("I am lord Voldemort btw 3:) ");
	userService.login("lucious");
	postService.upVotePostOrDownVote(4, true);
	postService.upVotePostOrDownVote(5, true); 
	userService.follow("tom");
	postService.reply(4, "I am with you dark lord!");
	userService.showNewsFeed(); //Follower, upvote-downvote and number of comments tested
	//userService.login("albus");
	
	}
}
