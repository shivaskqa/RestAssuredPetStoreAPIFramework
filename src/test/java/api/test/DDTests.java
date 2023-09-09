package api.test;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.ExcelUtility;

public class DDTests {
	
	@Test(priority=1)
	public void testAllPostRequests()
	{
		//UserID	UserName	FirstName	LastName	Email	Password	Phone

		List<Map<String, String>> data = ExcelUtility.readExcelFile();
		
		for(int i=0;i<data.size();i++)
		{
			Map<String,String> map=data.get(i);
		    
			User payload=new User();
			
			 payload.setId(Integer.parseInt(map.get("UserID")));
			 payload.setUsername(map.get("UserName"));
			 payload.setFirstName(map.get("FirstName"));
			 payload.setLastName(map.get("LastName"));
			 payload.setEmail(map.get("Email"));
			 payload.setPassword("Password");
			 payload.setPhone("Phone");
			 
		
		    UserEndPoints.createUser(payload);
		}
	}
	
	@Test(priority=2)
	public void testDeleteRequest()
	{
		List<String> usernames=ExcelUtility.getUserNames();
		
		for(String user:usernames)
		{
			UserEndPoints.deleteUser(user);
		}
	}

}
