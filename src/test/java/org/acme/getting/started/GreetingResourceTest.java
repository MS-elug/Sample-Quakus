package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

/** 
 * Test class of {@link GreetingResource}. 
 * It contains 4 unit test cases.  
 */
@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    /**
     * Test greeting endpoint with a valid user.
     * @TedAIGenerated 20240606180559
     */
    @Test
    public void testGreetingEndpointValidUser() {
        String name = "validUser";
        given()
          .when().get("/greeting/" + name)
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

    /**
     * Test greeting endpoint with an invalid user.
     * @TedAIGenerated 20240606180559
     */
    @Test
    public void testGreetingEndpointInvalidUser() {
        String name = "invalidUser";
        given()
          .when().get("/greeting/" + name)
          .then()
             .statusCode(200)
             .body(equalTo("User not found"));
    }

    /**
     * Test register endpoint with a new user.
     * @TedAIGenerated 20240606180559
     */
    @Test
    public void testRegisterEndpoint() {
        String userJson = "{\"name\":\"newUser\",\"email\":\"newuser@example.com\"}";
        given()
          .contentType("application/json")
          .body(userJson)
          .when()
          .post("/register")
          .then()
             .statusCode(200)
             .body("name", equalTo("newUser"))
             .body("email", equalTo("newuser@example.com"));
    }
}