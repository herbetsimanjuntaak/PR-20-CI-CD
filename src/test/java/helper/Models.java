package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Models {

    private static RequestSpecification request;

    public static void setUpHeaders() {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 2259048ef8b50ff36a730b1d6dcd5962cd3c9aa5210a7b4ca68b92c36d8abfc9");
    }
    public static Response getListUsers(String endpoint) {
        setUpHeaders();
        return request.when().get(endpoint);
    }
    public static String setUpId(String endpoint, int user_id ) {
        return endpoint + "/" + user_id;
    }
    public static Response hitUserById(String endpoint ) {
        setUpHeaders();
        return request.when().get(endpoint);
    }
    public static Response hitUserWrongId(String endpoint ) {
        setUpHeaders();
        return request.when().get(endpoint);
    }

    public static Response hitUserParams(String endpoint ,String name ) {
        setUpHeaders();
        request = request.param("name",name);
        return request.when().get(endpoint);
    }


}
