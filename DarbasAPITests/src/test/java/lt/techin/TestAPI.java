package lt.techin;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestAPI {

    @Test
    void getAllUsers() {
        given().

                when()
                .get("https://gorest.co.in/public/v2/users/")
                .then()
                .log().body()
                .assertThat().statusCode(200);

    }
    @Test
    void getUserWithId() {
        given().

                when()
                .get("https://gorest.co.in/public/v2/users/6180429")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("id", equalTo(6180429))
                .body("name", equalTo("Bhanumati Shukla"))
                .body("gender", equalTo("male"))
                .body("status", equalTo("inactive"));

    }
    @Test
    void getUserListFromThePage5() {
        given().

                when()
                .get("https://gorest.co.in/public/v2/users?page&per_page=20")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("id",hasSize(20));
    }
    @Test
    void createUseWithAttributesAndExtractUserIdAmount() {
        given().

                when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("id",hasSize(20));
    }

    @Test
    void createUserWithToken() {

        String user = """
                {
                        "name": "Dev Menon 2",
                        "email": "menonggdev@murray.test",
                        "gender": "female",
                        "status": "active"
                    }
                """;


        given()
        .headers("Authorization", "Bearer " + "e9ef5d6f4adbda40fd995d2651575cffa646772a3947a4049a40e8ad96fae70e", "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .log().body()
                .assertThat().statusCode(201);

    }
    @Test
    void createUserWithTokenWithValidationExtractUserId() {

        String user = """
                {
                        "name": "Dev Menonk",
                        "email": "menonggkjrhdev@murray.test",
                        "gender": "female",
                        "status": "active"
                    }
                """;


        Integer id = given()
                .headers("Authorization", "Bearer " + "e9ef5d6f4adbda40fd995d2651575cffa646772a3947a4049a40e8ad96fae70e", "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .log().body()
                .assertThat().statusCode(201)
                .body("id", notNullValue())
                .extract().path("id");
        System.out.println("ID: " + id);

    }

    @Test
    void getUserWithTokenWithValidationExtractUserId() {



        given()
                .headers("Authorization", "Bearer " + "e9ef5d6f4adbda40fd995d2651575cffa646772a3947a4049a40e8ad96fae70e", "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://gorest.co.in/public/v2/users/6193241")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("id", equalTo(6193241))
                .body("name", equalTo("Dev Menonk"));


    }



}
