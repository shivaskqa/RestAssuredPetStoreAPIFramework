package api.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtility {

	private static final String filePath = "C:\\Users\\Shiva\\eclipse-workspace\\RestAssuredPetStoreAPIFramework\\testData\\UserData.xlsx";
	private static final Fillo fillo = new Fillo();
	private static Connection connection = null;
	
	public static List<Map<String, String>> readExcelFile() {

		String table_Name = "data";
		String selectQuery = "select * from " + table_Name;

		List<Map<String, String>> excelData = new ArrayList<>();

		try {

			connection = fillo.getConnection(filePath);

			Recordset recordset = connection.executeQuery(selectQuery);

			  ArrayList<String> collection = recordset.getFieldNames();
			  int size = collection.size();
			
			while(recordset.next()) {
			  
			    Map<String, String> values = new HashMap<>();
			    for (int i = 0; i <=(size-1); i++) {
			        String colname = collection.get(i);
			        String colval = recordset.getField(colname);
			        values.put(colname, colval);
			    }
			    excelData.add(values);
			}
		} catch (FilloException e) {
			e.printStackTrace();
		}
		return excelData;
	}

	public static List<String> getUserNames() {

		List<Map<String,String>> data=readExcelFile();
		
		List<String> users=new ArrayList<String>();
		
		for(int i=0;i<data.size();i++)
		{
			Map<String,String> map=data.get(i);
                 for(Map.Entry<String,String> entry:map.entrySet())
                 {
                     String key=(String)entry.getKey();
                        if(key.equalsIgnoreCase("UserName"))
                        	users.add((String) entry.getValue());
                  
                 }
		}
		return users;
	}

	public static void main(String[] args) {

		System.out.println(getUserNames());
		
	}

}
