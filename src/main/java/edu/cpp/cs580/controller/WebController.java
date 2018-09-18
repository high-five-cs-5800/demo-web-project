package edu.cpp.cs580.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.cpp.cs580.App;
import edu.cpp.cs580.data.GpsProduct;
import edu.cpp.cs580.data.User;
import edu.cpp.cs580.data.provider.GpsProductManager;

import edu.cpp.cs580.data.provider.UserManager;
//import edu.csupomona.cs480.data.repository.TruckRepository;
import edu.cpp.cs580.data.provider.TruckInfoManager;
import edu.cpp.cs580.data.TruckInfo;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	
//	@Autowired
//	private TruckInfoManager truckManager;
	@Autowired
	private UserManager userManager;
	@Autowired
	private GpsProductManager gpsManager;
	
	
//	@Autowired
//	private TruckRepository truckRepository;
	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs580/ping
	 */
	@RequestMapping(value = "/cs580/healthcheck", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK-CS580 in Class Demo";
	}

	@RequestMapping(value = "/cs580/gpslist", method = RequestMethod.GET)
	List<GpsProduct> listGps() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return gpsManager.listGps();
	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 *
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs580/user/user101
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs580/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs580/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs580/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}
	
	/***************Simple API for Internet Connection - Roger
	 * @throws Exception *********************/
	@RequestMapping(value = "/cs580/pingInternet", method = RequestMethod.GET)
	String InternetCheck() throws Exception{
		String PingResult = "";
		InetAddress DNS1 = InetAddress.getByName("8.8.8.8");

        boolean ping = DNS1.isReachable(1000);

        if (!ping)
        {
            PingResult = "ERR_CONNECTION_TIMED_OUT";
        }
        else
        {
            PingResult = "CONNECTION_FOUND";
        }
        
		return PingResult;
	}
	/**************Bonnie
	 *  API to call Login page. Page layout will be updated in the future.
	 *  *********************/
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView welcomePage(){
    	ModelAndView modelAndView = new ModelAndView("loginpage.html");
		return modelAndView;
    }
	/*  cs580/chi-wei wang (john) -a3
	 * 
	 */
    @RequestMapping(value = "/cs580/chiwang/a3", method = RequestMethod.GET)
	int[] getFibonacciSequence() {
		// Will try to compute Fibonacci in O(n) time using memoization
		int maxSize = 10;
		int[] fib = new int[maxSize + 1];
		// Initialize first two numbers
		fib[0] = 0;
		fib[1] = 1;
		
		// Calculate next fibonacci numbers based on previously stored numbers
		for (int i = 2; i <= maxSize; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib;
	}
	//pass
    
//	@RequestMapping(value = "/cs580/foodtruck/{truckId}", method = RequestMethod.GET)
//	TruckInfo getTruckInfo(@PathVariable("truckId") Integer truckId) {
//		TruckInfo truck = truckManager.getTruckInfo(truckId);
//		return truck;
//	}
//	//pass
//	@RequestMapping(value = "/cs580/foodtruck/{truckId}", method = RequestMethod.POST)
//	TruckInfo updateTruckInfo(
//			@PathVariable("truckId") String id,
//			@RequestParam("name") String name,
//			@RequestParam(value = "type", required = false) String type) {
//		TruckInfo truck = new TruckInfo();
//		truck.setId(id);
//		truck.setName(name);
//		truck.setType(type);
//		truckManager.updateTruckInfo(truck);
//		return truck;
//	}
//	//pass
//	@RequestMapping(value = "/cs580/foodtruck/{truckId}", method = RequestMethod.DELETE)
//	void deleteTruckInfo(
//			@PathVariable("truckId") Integer truckId) {
//		truckManager.deleteTruckInfo(truckId);	
//	}
//	//pass
//	@RequestMapping(value = "/cs580/foodtruck/list", method = RequestMethod.GET)
//	List<TruckInfo> listAllTrucks() {
//		return truckManager.listAllTrucks();
//	}
//	
//	@RequestMapping(value = "/cs580/foodtruck/home", method = RequestMethod.GET)
//	ModelAndView getFoodtruckPage() {
//		ModelAndView modelAndView = new ModelAndView("foodtruck");
//		modelAndView.addObject("trucks", listAllTrucks());
//		return modelAndView;
//	}
    
    
}