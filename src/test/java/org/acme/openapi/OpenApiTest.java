package org.acme.openapi;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class OpenApiTest {
    @Test
    public void testOpenApi() {
        Response response = given()
                .accept(ContentType.JSON)
                .get("/q/openapi");

        response.then()
                .statusCode(HttpStatus.SC_OK)
                .header("Content-Type", "application/json;charset=UTF-8");
        assertEquals(HttpStatus.SC_OK, response.statusCode());
    }
}
