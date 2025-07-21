package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class apiUtils {
	public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response postRequest(String endpoint, String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

}
