package WebServiceObjects;
import java.io.IOException;
import io.restassured.builder.RequestSpecBuilder;
import utility.Props;

public class APITestBase {
	
	 private static APITestBase RA = null;  
	 APITestBase(){}  
	 
	 //Singleton initialization
	 public static APITestBase getInstance(){  
	   if (RA == null){ 
		   RA = new APITestBase(); 
	    }            
	  return RA;  
	 }  
	 
	 /**
	  * Prepare Request specification for request
	  * @return
	 * @throws IOException 
	  */
	 public RequestSpecBuilder getBaseRequestSpec() {
		
		 Props prop=new Props();
		 RequestSpecBuilder req=new RequestSpecBuilder();
		 req.setBaseUri(prop.getPropertyValue("baseURI")); 
		 
		 return req;
	 }
 	 
}
