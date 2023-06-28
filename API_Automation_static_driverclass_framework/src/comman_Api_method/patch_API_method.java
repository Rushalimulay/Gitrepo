package comman_Api_method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class patch_API_method {
	public static int responsestatuscode(String baseURI,String resource,String RequestBody) {
		RestAssured.baseURI=baseURI;
		int statuscode=given().config(RestAssured.config().sslConfig(
				new SSLConfig().allowAllHostnames())).header("Content-Type","application/json").body(RequestBody).
				when().post("/api/users").then().extract().statusCode();
		return statuscode;
	}
	public static String ResponseBody(String baseURI,String resourse,String RequestBody) {
		RestAssured.baseURI=baseURI;
		
		String responseBody = given().config(RestAssured.config().sslConfig(
				new SSLConfig().allowAllHostnames())).header("Content-Type","application/json").body(RequestBody).
				when().post("/api/users").then().extract().response().asString();
		return responseBody;
	}
	
}
