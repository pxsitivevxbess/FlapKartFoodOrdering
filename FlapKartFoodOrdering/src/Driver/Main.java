package Driver;

import DAO.UserDAO;
import Model.Order;
import Model.Restaurant;
import Model.User;
import Service.OrderService;
import Service.RestaurantService;
import Service.UserService;

public class Main {

	public static void main(String[] args) {
		OrderService orderService = OrderService.getInstance();
		RestaurantService restaurantService = RestaurantService.getInstance();
		UserService userService = UserService.getInstance();
		User registerUser = userService.register_user("Pralove", "M", 9811, "HSR");
		System.out.println("Output for register_user"+ registerUser);
        Restaurant registerRestaurant = restaurantService.register_restaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);
        System.out.println("Output for register_restaurant"+registerRestaurant);
        User currentUser = userService.login_user(9811);
        System.out.println("Output for login_user"+currentUser);
        Order currentOrderPlaced = orderService.place_order("Food Court-1",2);
        restaurantService.create_review("Food Court-1", 2, "Ok oK");
		restaurantService.show_restaurant("price");
		userService.order_history();
		}
}

//TODO Auto-generated method stub
//register_user(“Pralove”, “M”, “phoneNumber-1”, “HSR”)
//register_user(“Nitesh”, “M”, “phoneNumber-2”, “BTM”)
//register_user(“Vatsal”, “M”,  “phoneNumber-3”, “BTM”)
//
//login_user(“phoneNumber-1”)
//
//register_restaurant(“Food Court-1”, “BTM/HSR”, “NI Thali”, 100, 5)
//NOTE: we will have 2 delimiters in input : ',' to specify separate fields & '/' to identify different pincodes.
//register_restaurant(“Food Court-2”, “BTM”, “Burger”, 120, 3)
//
//login_user(“phoneNumber-2”)
//register_restaurant(“Food Court-3”, “HSR”, “SI Thali”, 150, 1)
//login_user(“phoneNumber-3”)
//show_restaurant(“price”)
//
//Output :  Food Court-2, Burger
//	   Food Court-1, NI Thali
//
//place_order(“Food Court-1”, 2)
//Output: Order Placed Successfully.
//
//place_order(““Food Court-2”, 7)
//Output : Cannot place order
//
//create_review(“Food Court-2”, 3, “Good Food”)
//create_review(“Food Court-1”, 5, “Nice Food”)
//
//show_restaurant(“rating”)
//Output :  Food Court-1, NI Thali
//	   Food Court-2, Burger
//
//login_user(“phoneNumber-1”)
//update_quantity(“Food Court-2”, 5)
//Output: Food Court-2, BTM, Burger - 8
//
//update_location(“Food Court-2”, “BTM/HSR”)
//Output: Food Court-2, “BTM/HSR”, Burger - 8