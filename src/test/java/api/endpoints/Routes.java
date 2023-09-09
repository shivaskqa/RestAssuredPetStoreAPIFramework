package api.endpoints;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
Swagger URI ----> https://petstore.swagger.io

Post --> https://petstore.swagger.io/v2/user
Get --> https://petstore.swagger.io/v2/user/{username}
Put --> https://petstore.swagger.io/v2/user/{username}
Delete --> https://petstore.swagger.io/v2/user/{username}

*/


public class Routes {
	
	/*
	 * public static String base_url="https://petstore.swagger.io/v2";
	 * 
	 * //User Model public static String createUser_url=base_url+"/user"; public
	 * static String getUser_url=base_url+"/user/{username}"; public static String
	 * updateUser_url=base_url+"/user/{username}"; public static String
	 * deleteUser_url=base_url+"/user/{username}";
	 */
	
	private static Properties properties=null;
	private static String propFilePath=System.getProperty("user.dir")+"\\src\\test\\resources\\routes.properties";
	public static String createUser_url;
	public static String getUser_url;
	public static String updateUser_url;
	public static String deleteUser_url;
	
	
	public Routes()
	{
		try
		{
			properties=new Properties();
			FileInputStream fis=new FileInputStream(propFilePath);
			properties.load(fis);
			createUser_url=(String)properties.get("CreateUser_url");
			getUser_url=(String)properties.get("GetUser_url");
			updateUser_url=(String)properties.get("UpdateUser_url");
			deleteUser_url=(String)properties.get("DeleteUser_url");
			
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
}
