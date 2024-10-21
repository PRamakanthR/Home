package practrice1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.Assert;
import io.restassured.response.Response;

public class firstRequests {
	@Test
	public void getUser() {
		given()

		.when()
		.get("https://reqres.in/api/users?page=2")

		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();

	}
	@Test
	public void postReqiuest() {
		HashMap hash=new HashMap();
		hash.put("name", "morpheus");
		hash.put("job", "IT");
		given()
		.baseUri("https://reqres.in")
		.contentType("application/json")
		.body(hash)
		
		.when()
		.post("/api/users")
		.then()
		.statusCode(201)
		.log().all()
		;
		
	}
	@Test
	public void someMethod() {
	Response response=RestAssured.get("https://reqres.in/api/users?page=2");
	int statusCode=response.statusCode();
	Assert.assertEquals(statusCode, 200);
	}
}

