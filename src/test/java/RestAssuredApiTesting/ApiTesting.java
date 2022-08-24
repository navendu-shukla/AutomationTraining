package RestAssuredApiTesting;




import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//All GET requests 

public class ApiTesting {
	@Test(priority=1)
	void getListUsers() {
		//given().header("Content-Type","application/json").param("page", 2).get("https://reqres.in/api/users?page=2").then().statusCode(200)
		//.body("data.id[1]", equalTo(8) ).body("data.first_name", hasItems("Michael","Lindsay"));
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:" + responseBody);
		int statusCode = response.getStatusCode() ;
		//System.out.println("Status code is:" + statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine = response.getStatusLine();
		//System.out.println("StatusLine is:"+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		JsonPath json = new JsonPath (response.asString());
		int s = json.getInt("data.size()");
		for(int i=0; i<s; i++) {
			String id = json.getString("data["+i+"].id");
			String firstName = json.getString("data["+i+"].first_name");
			System.out.println("id:"+id);
			System.out.println("firstName:"+firstName);
			
		}
	}
	
	@Test(priority=2)
	void getSingleUser(){
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/users/2");
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:" + responseBody);
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");
		int statusCode = response.getStatusCode() ;
		//System.out.println("Status code is:" + statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine = response.getStatusLine();
		//System.out.println("StatusLine is:"+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		 
	}
	
	@Test(priority=3)
	void getSingleUserNotFound(){

		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/users/23");
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:" + responseBody);
		int statusCode = response.getStatusCode() ;
		//System.out.println("Status code is:" + statusCode);
		Assert.assertEquals(statusCode, 404);
		
	}
	
	@Test(priority=4)
	void getListResource(){
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/unknown");
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:" + responseBody);
		Headers allHeaders = response.headers();
		for(Header header:allHeaders) {
			System.out.println(header.getName()+" "+ header.getValue());
		}
		int statusCode = response.getStatusCode() ;
		//System.out.println("Status code is:" + statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine = response.getStatusLine();
		//System.out.println("StatusLine is:"+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test(priority=5)
	void getSingleResource(){
	
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/unknown/2");
		
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("data.id"));
		System.out.println(jsonpath.get("data.name"));
		System.out.println(jsonpath.get("support.url"));
		System.out.println(jsonpath.get("support.text"));
		
		int statusCode = response.getStatusCode() ;
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test(priority=6)
	void getSingleResourceNotFound(){
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/unknown/23");
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:" + responseBody);
		int statusCode = response.getStatusCode() ;
		Assert.assertEquals(statusCode, 404);
	}
	
	@Test(priority=7)
	void DelayedResponse(){
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("data.id"));
		System.out.println(jsonpath.get("data.name"));
		System.out.println(jsonpath.get("support.url"));
		System.out.println(jsonpath.get("support.text"));
		
		int statusCode = response.getStatusCode() ;
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	//All Post requests 
	
		@Test(priority=8)
		public void postCreate() {
			//Map<String,Object> map = new HashMap<String,Object>();
			//map.put("name", "Ria");
			//map.put("job", "Automation");
			//System.out.println(map);
			//given().header("Content-Type","application/json").when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
			
			RestAssured.baseURI="https://reqres.in";
			RequestSpecification httpRequest = RestAssured.given();
			JSONObject requestParams = new JSONObject() ;
			requestParams.put("name", "morpheus");
			requestParams.put("job", "leader");
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			Response response = httpRequest.request(Method.POST,"/api/users");
			String responseBody = response.getBody().asString();
			System.out.println("Response body is:" + responseBody);
			int statusCode = response.getStatusCode() ;
			//System.out.println("Status code is:" + statusCode);
			Assert.assertEquals(statusCode, 201);
			
		}
		
		@Test(priority=9)
		public void postRegisterSuccessful() {
			
			RestAssured.baseURI="https://reqres.in";
			RequestSpecification httpRequest = RestAssured.given();
			
			JSONObject requestParams = new JSONObject() ;
			requestParams.put("email", "eve.holt@reqres.in");
			requestParams.put("password", "pistol");
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			
			Response response = httpRequest.request(Method.POST,"/api/register");
			String responseBody = response.getBody().asString();
			System.out.println("Response body is:" + responseBody);
			
			int statusCode = response.getStatusCode() ;
			Assert.assertEquals(statusCode, 200);
		}
		@Test(priority=10)
		public void postRegisterUnsuccessful() {
			
			RestAssured.baseURI="https://reqres.in";
			RequestSpecification httpRequest = RestAssured.given();
			
			JSONObject requestParams = new JSONObject() ;
			requestParams.put("email", "sydney@fife");
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			
			Response response = httpRequest.request(Method.POST,"/api/register");
			String responseBody = response.getBody().asString();
			System.out.println("Response body is:" + responseBody);
			
			int statusCode = response.getStatusCode() ;
			Assert.assertEquals(statusCode, 400);
		}
		@Test(priority=11)
		public void postLoginsSccessful() {
			
			RestAssured.baseURI="https://reqres.in";
			RequestSpecification httpRequest = RestAssured.given();
			
			JSONObject requestParams = new JSONObject() ;
			requestParams.put("email", "eve.holt@reqres.in");
			requestParams.put("password", "cityslicka");
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			
			Response response = httpRequest.request(Method.POST,"/api/login");
			String responseBody = response.getBody().asString();
			System.out.println("Response body is:" + responseBody);
			
			int statusCode = response.getStatusCode() ;
			Assert.assertEquals(statusCode, 200);
		}
		
		@Test(priority=12)
		public void postLoginUnsuccessful() {
			
			RestAssured.baseURI="https://reqres.in";
			RequestSpecification httpRequest = RestAssured.given();
			
			JSONObject requestParams = new JSONObject() ;
			requestParams.put("email", "peter@klaven");
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			
			Response response = httpRequest.request(Method.POST,"/api/login");
			String responseBody = response.getBody().asString();
			System.out.println("Response body is:" + responseBody);
			
			int statusCode = response.getStatusCode() ;
			Assert.assertEquals(statusCode, 400);
		}
		@Test(priority=13)
        public void put1() {
			
			RestAssured.baseURI="https://reqres.in";
			RequestSpecification httpRequest = RestAssured.given();
			
			JSONObject requestParams = new JSONObject() ;
			requestParams.put("name", "morpheus");
			requestParams.put("job", "zion resident");
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			
			Response response = httpRequest.request(Method.PUT,"/api/users/2");
			String responseBody = response.getBody().asString();
			System.out.println("Response body is:" + responseBody);
			
			int statusCode = response.getStatusCode() ;
			Assert.assertEquals(statusCode, 200);
		}
	
        @Test(priority=14)
		public void patch1() {
			RestAssured.baseURI="https://reqres.in";
			RequestSpecification httpRequest = RestAssured.given();
			
			JSONObject requestParams = new JSONObject() ;
			requestParams.put("name", "morpheus");
			requestParams.put("job", "zion resident");
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			
			Response response = httpRequest.request(Method.PATCH,"/api/users/2");
			String responseBody = response.getBody().asString();
			System.out.println("Response body is:" + responseBody);
			
			int statusCode = response.getStatusCode() ;
			Assert.assertEquals(statusCode, 200);
		}
	
	    @Test(priority=15)
		public void Delete() {
	    	
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.DELETE,"/api/users/2");
		
		int statusCode = response.getStatusCode() ;
		Assert.assertEquals(statusCode, 204);
		}
	}
