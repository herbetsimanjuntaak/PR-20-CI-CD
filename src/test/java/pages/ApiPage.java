package pages;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import java.io.File;
import java.util.List;
import static helper.Models.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ApiPage {

    String setUpUrl, finalEndpoint;

    Response res;

    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setUpUrl = Endpoint.GET_LIST_USERS;
                break;
            case "GET_LIST_USER_BY_ID":
                setUpUrl = Endpoint.GET_LIST_USERS_ID;
                break;
            case "CREATE_NEW_USERS":
                setUpUrl = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setUpUrl = Endpoint.DELETE_USERS;
                break;
            case "POST_USERS":
                setUpUrl = Endpoint.POST_USERS;
                break;
            case "PATCH_USERS":
                setUpUrl = Endpoint.PATCH_USERS;
                break;
            case "PUT_USERS":
                setUpUrl = Endpoint.PUT_USERS;
                break;
            case "GET_DATA_WRONG_ID":
                setUpUrl = Endpoint.GET_DATA_WRONG_ID;
                break;
            case "GET_ENDPOINT_WRONG":
                setUpUrl = Endpoint.GET_DATA_WRONG_ID;
                break;
            default:
                System.out.println("input valid url :)");
        }
    }

    public void hitAPIGetListUsers(){
        res = Models.getListUsers(setUpUrl);
    }
    public void validationStatusCodeIsEquals(Integer status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
        System.out.println(res.statusCode());
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationResponseJsonWithJSONSchema(String fileName){
        File JSONFile = Utility.getJSONSchemaFile(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void prepareValidId(int id) {
        finalEndpoint = setUpId(setUpUrl,id);
    }
    public void hitAPIGetUserById() {
        res = hitUserById(finalEndpoint);
    }
    public void validationResponseBodyGetUserById() {

        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        Assertions.assertThat(id).isNotNull();
        Assertions.assertThat(name).isNotNull();
        Assertions.assertThat(email).isNotNull();
        Assertions.assertThat(gender).isIn("female", "male");
        Assertions.assertThat(status).isIn("active", "inactive");
    }

    public void hitApiGetDataWrongId() {
        res = hitUserWrongId(setUpUrl);
    }
    public void validationResponseBodyWrongId(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String message = jsonPathEvaluator.get("message");
        assertThat(message).isIn("Resource not found");
    }

    public void hitAPIGetListUsersWithParams(String name) {
        res = hitUserParams(setUpUrl,name);
        System.out.println(res.getBody().asString());
    }
    public void validateDataUserNameShouldBeContain(String name) {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String names = jsonPathEvaluator.getString("[0].name");
        System.out.println(name);
        System.out.println(names);
        assertThat(names).isNotNull();
        assertThat(names).hasSizeGreaterThan(0);
        assertThat(names).containsIgnoringCase(name);
    }

}
