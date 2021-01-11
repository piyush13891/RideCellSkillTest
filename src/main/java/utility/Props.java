package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Props {

	Properties prop=new Properties();	
	
	public Props(){		
		
		try{
			FileReader reader=new FileReader("data/param.properties");    	  
			prop.load(reader);  
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public String getPropertyValue(String propertyName){
		return prop.getProperty(propertyName);
	}
	
}
