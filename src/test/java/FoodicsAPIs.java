import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FoodicsAPIs {

    private final String API_URL = "https://pay2.foodics.dev/cp_internal";

    @BeforeAll
    public static void setup() {
        baseURI = "https://pay2.foodics.dev";
        basePath = "/cp_internal";
    }

    @Test
    public void loginSuccessTest() {
        given()
                .contentType("application/json")
                .body("{\"username\":\"merchant@foodics.com\",\"password\":\"123456\"}")
                .when()
                .post(API_URL + "/login")
                .then()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Test
    public void loginFailureTest() {
        given()
                .contentType("application/json")
                .body("{\"username\":\"merchant@foodics.com\",\"password\":\"wrongpassword\"}")
                .when()
                .post(API_URL + "/login")
                .then()
                .statusCode(302) // The API will return a redirect status code
                .header("Location", "/cp_internal/login?error=true") // Check that the user was redirected to the login page with an error message
                .extract()
                .response();
    }


    @Test
    public void whoamiTest() {
        // Send a POST request to the login endpoint to obtain a token
        Response loginResponse = given()
                .contentType("application/json")
                .body("{\"username\":\"merchant@foodics.com\",\"password\":\"123456\"}")
                .post(API_URL + "/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Extract the token from the login response
        String token = loginResponse.jsonPath().getString("data.token");

        // Send a GET request to the whoami endpoint with the token in the authorization header
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(API_URL + "/whoami")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("data.username", equalTo("merchant@foodics.com"));
    }

}
