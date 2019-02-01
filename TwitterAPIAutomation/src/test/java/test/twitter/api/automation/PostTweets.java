package test.twitter.api.automation;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * This class contain test case to create tweet on Your timeline.
 * 
 * @author Tushar Naik
 *
 */
public class PostTweets {

	// Authentication Parameters to access API
	
	public String ConsumerKey = "O1uqv87kdedU2UVQcMB2ejt5k";
	public String ConsumerSecret = "dm45Sgm0y1sPTD7u3vs7i7cSSCwyCX7WhkZWTWIEduwsgMg5gH";
	public String Token = "1089173373563764737-Pqpon5o6cRb44V2zthc63LK0iON8vQ";
	public String TokenSecret = "fdWzzlh5rGduM9cpxU4jYgMbmKFT8IP1M8uZp5wwNBbdP";
	public String id = null;

	/**
	 * This test case will create a tweet by using API.
	 * Required parameters for authentication - ConsumerKey, ConsumerSecret, Token, TokenSecret.
	 */
	@Test
	public void createTweet() {

		// Base URL for API
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";

		// Getting response by hitting url and provides authentication parameters
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
				.queryParam("status", "I am creating this tweet with Automation").when().post("/update.json").then()
				.extract().response();

		// Response in String
		String response = res.asString();
		System.out.println(response);

		// Converting response into json format
		
		JsonPath js = new JsonPath(response);
		System.out.println("Below is the tweet added");

		// Print tweet's text and its id
		
		System.out.println("Text in Tweets is :" + js.get("text"));
		System.out.println("ID is :" +js.get("id"));
		id = js.get("id").toString();

	}

}
