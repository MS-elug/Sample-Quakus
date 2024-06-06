package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

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
     * Test greeting endpoint with a valid user name.
     * @TedAIGenerated 20240606180148
     */
    @Test
    public void testGreetingEndpointWithValidUser() {
        given()
          .pathParam("name", "John")
          .when().get("/greeting/{name}")
          .then()
             .statusCode(200)
             .body(is("Hello, John!"));
    }

    /**
     * Test greeting endpoint with an invalid user name.
     * @TedAIGenerated 20240606180148
     */
    @Test
    public void testGreetingEndpointWithInvalidUser() {
        given()
          .pathParam("name", "UnknownUser")
          .when().get("/greeting/{name}")
          .then()
             .statusCode(200)
             .body(is("User not found"));
    }

    /**
     * Test register endpoint with valid user data.
     * @TedAIGenerated 20240606180148
     */
    @Test
    public void testRegisterEndpointWithValidUser() {
        String newUserJson = "{\"name\":\"Jane\",\"email\":\"jane@example.com\"}";

        given()
          .contentType("application/json")
          .body(newUserJson)
          .when().post("/register")
          .then()
             .statusCode(200)
             .body("name", equalTo("Jane"))
             .body("email", equalTo("jane@example.com"));
    }

    /**
     * Test register endpoint with invalid user data.
     * @TedAIGenerated 20240606180148
     */
    @Test
    public void testRegisterEndpointWithInvalidUser() {
        String invalidUserJson = "{\"name\":\"InvalidUser\"}";

        given()
          .contentType("application/json")
          .body(invalidUserJson)
          .when().post("/register")
          .then()
             .statusCode(400)
             .body(containsString("email is mandatory"))
             .body(not(containsString("InvalidUser")));
    }
}