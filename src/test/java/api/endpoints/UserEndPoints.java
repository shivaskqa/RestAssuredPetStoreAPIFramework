package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



// This class is created for CRUD operations.
// Create , Read , Update and Delete requests api

public class UserEndPoints {

	
	
	//Create user
	public static Response createUser(User payload)
	{
	
		Routes obj=new Routes();	
	Response response=	given()
		 					.contentType(ContentType.JSON)
		 					.accept(ContentType.JSON)
		 					.body(payload)
		 				.when()
		 					.post(Routes.createUser_url);
	
	  return response;
	}
	
	//Get user
	public static Response getUser(String userName)
	{
		Routes obj=new Routes();
	return   given()
		 					.pathParam("username", userName)
		 				.when()
		 					.get(Routes.getUser_url);
	
	}
	
	//Update user
	public static Response updateUser(String userName,User payload)
	{
		Routes obj=new Routes();
	Response response=	given()
		 					.contentType(ContentType.JSON)
		 					.accept(ContentType.JSON)
		 					.body(payload)
		 					.pathParam("username", userName)
		 				.when()
		 					.put(Routes.updateUser_url);
	
	  return response;
	}
	
	//Delete user
	public static Response deleteUser(String userName)
	{
		Routes obj=new Routes();
	Response response=	given()
		 					.contentType(ContentType.JSON)
		 					.accept(ContentType.JSON)
		 					.pathParam("username", userName)
		 				.when()
		 					.delete(Routes.deleteUser_url);
	
	  return response;
	}
}
