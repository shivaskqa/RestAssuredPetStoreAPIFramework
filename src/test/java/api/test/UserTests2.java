package api.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	List<User> listofUsers;
	User userData1;
	public Logger logger;

	@BeforeClass
	public void setUp() {
		listofUsers = new ArrayList<User>();
		
		listofUsers.add(new User(1, "Virushka", "Virat", "Kohli", "virat.kohli@bcci.co.in", "virushka123", "+91-6303456789",1));
		listofUsers.add(new User(2, "Rohitstar", "Rohit", "Sharma", "rohit45@bcci.co.in", "rohit45", "+91-6303809012",1));
		listofUsers.add(new User(3, "Suryakumaryadava", "Surya Kumar", "Ydav", "surya36063@bcci.co.in", "skysurya","+91-6303809013", 1));
		listofUsers.add(new User(4, "RavinJadeja", "Ravindra", "Jadeja", "jaddubhai@bcci.co.in", "jaddu10","+91-6303809014", 1));
		listofUsers.add(new User(5, "RPant", "Rishabh", "Pant", "rpant@bcci@co.in", "rishabhpant17", "+91-6303809015",1));
		listofUsers.add(new User(6, "TVerma", "Tilak", "Verma", "tverma@bcci.co.in", "tverma33", "+91-6303809016",1));
		
		//Logs initiation
		logger=LogManager.getLogger(this.getClass());
		
	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("*****************Creating new users via Post Request ******************");
		Response response;
		for (User userData : listofUsers) {
			response = UserEndPoints2.createUser(userData);
			response.then().log().all();

			Assert.assertEquals(response.getStatusCode(), 200);
			}
		logger.info("*****************New users are created successfully via Post Request ******************");
	}
	
   @Test(priority=2)
   public void getUser()
   {
	   logger.info("***************** Fetching user details via getUser request ******************");
	   Response response=UserEndPoints2.getUser("Rohitstar");
	   response.then().log().all();
	   String username=response.jsonPath().get("username");
	   System.out.println(username);
	   Assert.assertEquals(response.getStatusCode(), 200);
	   logger.info("***************** User details are fetched successfully via getUser request with Username ******************");
   }
   
   @Test(priority=3)
   public void testUpdateUser()
   {
	   logger.info("***************** Updating existing user details via Update request ******************");
	   
	   	userData1=new User(6,"HPandya","Hardik","Pandya","hardik.pandya@gmail.com","hpandya33","hardikpandya123",1);
	
		Response response=UserEndPoints2.updateUser("TVerma", userData1);
				response.then().log().body();
				
       Assert.assertEquals(200, response.getStatusCode());
       
       //Check the data has been updated
       Response responseAfterUpdate=UserEndPoints.getUser("HPandya");
         Assert.assertEquals(200,responseAfterUpdate.getStatusCode());
         
         logger.info("***************** User details are updated successfully via Update Request ******************");
   }
   
   @Test(priority=4)
   public void testDeleteUserByName()
   {
	   logger.info("***************** Delete request has been raised for deleting user details at server side ******************");
	   String username="HPandya";
	   Response response=UserEndPoints2.deleteUser(username);
	   response.then().log().all();
	   
	   String user=response.jsonPath().get("username");
	   System.out.println(user);
	   
	   Assert.assertEquals(response.getStatusCode(),200);
	   logger.info("***************** User details have been deleted successfully via Delete request  ******************");
   }
} 