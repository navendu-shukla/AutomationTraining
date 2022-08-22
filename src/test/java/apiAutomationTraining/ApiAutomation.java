package apiAutomationTraining;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; 
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

public class ApiAutomation {

	final static String url="https://reqres.in";
	
	@Test(priority = 1)
	public static  void getListUsers() {
		System.out.println("LIST USERS USING GET METHOD");
		Response res=given().when().get(url+"/api/users?page=2");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//String bodyString=body.asString();
//		res.then().body("data.id[0]", equalTo(7)).body("data.id[1]", equalTo(8));
//		String page=res.jsonPath().get("page").toString();
//		String per_page=res.jsonPath().get("per_page").toString();
//		String total_pages=res.jsonPath().get("total_pages").toString();
//		String total=res.jsonPath().get("total").toString();
//		String data1=res.jsonPath().get("data[0]").toString();
//		//System.out.println(page);
//		Assert.assertEquals(page, "2");
//		Assert.assertEquals(per_page, "6");
//		Assert.assertEquals(total, "12");
//		Assert.assertEquals(total_pages, "2");
		 //convert JSON to string
	      JsonPath j = new JsonPath(res.asString());

	      //get values of JSON array after getting array size
	      int s = j.getInt("data.size()");
	      for(int i = 0; i < s; i++) {
	         
	         System.out.println(j.getString("data["+i+"]"));
	        // System.out.println(j.getString("data["+i+"].email"));
	      }
		System.out.println("Reponse body elements validated successfully");
	

		
	}
	@Test(priority = 2)
	public static void getSingleUser() {
		System.out.println("SINGLE USERS USING GET METHOD");
		Response res=given().when().get(url+"/api/users/2");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);
		res.then().assertThat().statusCode(200);
		
//		String data=res.jsonPath().get("data").toString();
//
//		System.out.println(data);
//		String expectedData="{id=2, email=janet.weaver@reqres.in, first_name=Janet, last_name=Weaver,"
//				+ " avatar=https://reqres.in/img/faces/2-image.jpg}";
//		Assert.assertEquals(data, expectedData);
		 JsonPath j = new JsonPath(res.asString());

	      System.out.println(j.getString("data"));
		System.out.println("Reponse body elements validated successfully");
	      
		
	}
	@Test(priority = 3)
	public static void getUserNotFound() {
		System.out.println("USERS NOT FOUND USING GET METHOD");
		Response res=given().when().get(url+"/api/users/23");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(404);
	}
	@Test(priority = 4)
	public static  void getListResource() {
		System.out.println("LIST RESOURCES USING GET METHOD");
		Response res=given().when().get(url+"/api/unknown");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);
		res.then().assertThat().statusCode(200);
		
		
		
//		String page=res.jsonPath().get("page").toString();
//		String per_page=res.jsonPath().get("per_page").toString();
//		String total_pages=res.jsonPath().get("total_pages").toString();
//		String total=res.jsonPath().get("total").toString();
//		//System.out.println(page);
//		Assert.assertEquals(page, "1");
//		Assert.assertEquals(per_page, "6");
//		Assert.assertEquals(total, "12");
//		Assert.assertEquals(total_pages, "2");
		  JsonPath j = new JsonPath(res.asString());

	      //get values of JSON array after getting array size
	      int s = j.getInt("data.size()");
	      for(int i = 0; i < s; i++) {
	         
	         System.out.println(j.getString("data["+i+"]"));
	        // System.out.println(j.getString("data["+i+"].email"));
	      }
		System.out.println("Reponse body elements validated successfully");
	

		
	}
	
	@Test(priority = 5)
	public static void getListSingleResource() {
		System.out.println("LIST SINGLE RESOURCE USING GET METHOD");
		Response res=given().when().get(url+"/api/unknown/2");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);
		res.then().assertThat().statusCode(200);
		
//		String data=res.jsonPath().get("data").toString();
//		//System.out.println(data);
//		String expectedData="{id=2, name=fuchsia rose, year=2001, color=#C74375, pantone_value=17-2031}";
//		Assert.assertEquals(data, expectedData);
		
		 JsonPath j = new JsonPath(res.asString());

	      System.out.println(j.getString("data"));
		System.out.println("Reponse body elements validated successfully");
		
	}
	
	@Test(priority = 6)
	public static void getSingleResourceNotFound() {
		System.out.println("SINGLE RESOURCE NOT FOUND USING GET METHOD");
		Response res=given().when().get(url+"/api/unknown/23");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(404);
	}
	
	@Test(priority = 7)
	public static void postCreate() {
		System.out.println("CREATE USING POST METHOD");
		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");
		
		Response res=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post(url+"/api/users");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(201);
		

		String body=res.body().asPrettyString();
		
		System.out.println(body);
		
		String name=res.jsonPath().get("name").toString();
		String job=res.jsonPath().get("job").toString();
		String id=res.jsonPath().get("id").toString();
		//System.out.println(page);
	
		Assert.assertEquals(name, "morpheus");
		Assert.assertEquals(job, "leader");
		Assert.assertNotNull(id);
		System.out.println("Reponse body elements validated successfully");

		
	}
	@Test(priority = 8)
	public static void putUpdate() {
		System.out.println("UPDATE USING PUT METHOD");
		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		Response res=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
				body(request.toJSONString()).when().put(url+"/api/users/2");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(200);
		

		String body=res.body().asPrettyString();
		System.out.println(body);
		String name=res.jsonPath().get("name").toString();
		String job=res.jsonPath().get("job").toString();
		//System.out.println(page);
	
		Assert.assertEquals(name, "morpheus");
		Assert.assertEquals(job, "zion resident");
		System.out.println("Reponse body elements validated successfully");
		
	}
	
	@Test(priority = 9)
	public static void patchUpdate() {
		System.out.println("UPDATE USING PATCH METHOD");
		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		Response res=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch(url+"/api/users/2");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(200);
		

		String body=res.body().asPrettyString();
		System.out.println(body);
		
		String name=res.jsonPath().get("name").toString();
		String job=res.jsonPath().get("job").toString();
		//System.out.println(page);
	
		Assert.assertEquals(name, "morpheus");
		Assert.assertEquals(job, "zion resident");
		System.out.println("Reponse body elements validated successfully");

		
	}
	@Test(priority = 10)
	public static void deleteUser() {
		System.out.println("DELETE USER USING DELETE METHOD");
		
		
		Response res=given().when().delete(url+"/api/users/2");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(204);
		
	}
	
	@Test(priority = 11)
	public static void postRegisterSuccessful() {
		System.out.println("REGISTER SUCCESSFUL USING POST METHOD");
		JSONObject request=new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistol");
		
		Response res=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post(url+"/api/register");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(200);
		

		String body=res.body().asPrettyString();
		System.out.println(body);
		
		String id=res.jsonPath().get("id").toString();
		String token=res.jsonPath().get("token").toString();
		//System.out.println(page);
	
		Assert.assertEquals(id, "4");
		Assert.assertEquals(token, "QpwL5tke4Pnpja7X4");
		System.out.println("Reponse body elements validated successfully");

		
	}
	
	@Test(priority = 12)
	public static void postRegisterUnsuccessful() {
		System.out.println("REGISTER UNSUCCESSFUL USING POST METHOD");
		JSONObject request=new JSONObject();
		request.put("email", "sydney@fife");
		
		
		Response res=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post(url+"/api/register");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(400);
		

		String body=res.body().asPrettyString();
		System.out.println(body);
		
		String error=res.jsonPath().get("error").toString();
		
		//System.out.println(page);
	
		Assert.assertEquals(error, "Missing password");
		System.out.println("Reponse body elements validated successfully");

		
	}
	
	
	
	@Test(priority = 13)
	public static void postLoginSuccessful() {
		System.out.println("LOGIN SUCCESSFUL USING POST METHOD");
		JSONObject request=new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");
		
		
		Response res=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post(url+"/api/login");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(200);
		

		String body=res.body().asPrettyString();
		System.out.println(body);
		
		String token=res.jsonPath().get("token").toString();
		//System.out.println(page);
		Assert.assertEquals(token, "QpwL5tke4Pnpja7X4");
		System.out.println("Reponse body elements validated successfully");

		
	}
	
	@Test(priority = 14)
	public static void postLoginUnsuccessful() {
		System.out.println("LOGIN UNSUCCESSFUL USING POST METHOD");
		JSONObject request=new JSONObject();
		request.put("email", "peter@klaven");
		
		
		
		Response res=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post(url+"/api/login");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);	
		res.then().assertThat().statusCode(400);
		

		String body=res.body().asPrettyString();
		System.out.println(body);
		
		String error=res.jsonPath().get("error").toString();
		
		//System.out.println(page);
	
		Assert.assertEquals(error, "Missing password");
		System.out.println("Reponse body elements validated successfully");

		
	}
	
	@Test(priority = 15)
	public static  void getDelayedResponse() {
		System.out.println("DELAYED RESPONSE USING GET METHOD");
		Response res=given().when().get(url+"/api/users?delay=3");
		int statusCode=res.getStatusCode();
		System.out.println("Status code is "+statusCode);
		res.then().assertThat().statusCode(200);
		
		
		
//		String page=res.jsonPath().get("page").toString();
//		String per_page=res.jsonPath().get("per_page").toString();
//		String total_pages=res.jsonPath().get("total_pages").toString();
//		String total=res.jsonPath().get("total").toString();
//		//System.out.println(page);
//		Assert.assertEquals(page, "1");
//		Assert.assertEquals(per_page, "6");
//		Assert.assertEquals(total, "12");
//		Assert.assertEquals(total_pages, "2");
		JsonPath j = new JsonPath(res.asString());

	      //get values of JSON array after getting array size
	      int s = j.getInt("data.size()");
	      for(int i = 0; i < s; i++) {
	         
	         System.out.println(j.getString("data["+i+"]"));
	        // System.out.println(j.getString("data["+i+"].email"));
	      }
		System.out.println("Reponse body elements validated successfully");
	

		
	}
	
	
	

}
