package WebServiceObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.TreeMap;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.Props;

public class RepositoriesAPI extends APITestBase{

	/**
	  * Get request response for the request specification passed.
	  * @param reqSpec
	  * @return
	  */
	 public Response getRepositoryDataAPI(RequestSpecification reqSpec){		 
		return RestAssured.given().spec(reqSpec).get();		 
	 }
	 	  
	 /**
	  * Verify Response 
	  * @param resp
	  * @param respCode
	  */
	 public void verifyRespCode(Response resp, int respCode){
		 assertEquals(respCode, resp.getStatusCode(), "Response Code is not correct. Getting : " + resp.getStatusCode());		 
	 }
	 
	 /**
	  * Extract repository Names and details
	  * @param resp
	  * @param respCode
	  */
	 public TreeMap<String, String> extractDetailsAPI(Response resp){
		 
		 JsonPath jsonPath = new JsonPath(resp.getBody().asString());
		 
		 List<String> names = jsonPath.getList("name");
		 List<String> description = jsonPath.getList("description");
		 
		 TreeMap<String, String> map= new TreeMap<String, String> ();
		 
		 for(int i=0; i< names.size();i++){
			 map.put(names.get(i), description.get(i));
		 }
		 
		 return map;
	 }
	 
	 public RequestSpecBuilder setBasePath(RequestSpecBuilder reqSpec){
		 return reqSpec.setBasePath(new Props().getPropertyValue("repositoriesPath"));
	 }
	
}
