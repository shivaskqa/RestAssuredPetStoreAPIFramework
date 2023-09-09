package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



// This class is created for CRUD operations.
// Create , Read , Update and Delete requests api

public class UserEndPoints2 {

	
	
	
    static ResourceBundle getURL()
    {
    	ResourceBundle routes=ResourceBundle.getBundle("routes");
    	return routes;
    }
	
	
	//Create user
	public static Response createUser(User payload)
	{
	
		//Routes obj=new Routes();
		
	String createUser_url=getURL().getString("CreateUser_url");
		
	Response response=	given()
		 					.contentType(ContentType.JSON)
		 					.accept(ContentType.JSON)
		 					.body(payload)
		 				.when()
		 					.post(createUser_url);
	
	  return response;
	}
	
	//Get user
	public static Response getUser(String userName)
	{
	
	//Routes obj=new Routes();
	
	String getUser_url=getURL().getString("GetUser_url");
		
	return   given()
		 					.pathParam("username", userName)
		 				.when()
		 					.get(getUser_url);
	
	}
	
	//Update user
	public static Response updateUser(String userName,User payload)
	{
		//Routes obj=new Routes();
	
		String updateUser_url=getURL().getString("UpdateUser_url");
		Response response=	given()
		 					.contentType(ContentType.JSON)
		 					.accept(ContentType.JSON)
		 					.body(payload)
		 					.pathParam("username", userName)
		 				.when()
		 					.put(updateUser_url);
	
	  return response;
	}
	
	//Delete user
	public static Response deleteUser(String userName)
	{
		//Routes obj=new Routes();
		
	String 	deleteUser_url=getURL().getString("deleteUser_url");
	Response response=	given()
		 					.contentType(ContentType.JSON)
		 					.accept(ContentType.JSON)
		 					.pathParam("username", userName)
		 				.when()
		 					.delete(deleteUser_url);
	
	  return response;
	}
}
