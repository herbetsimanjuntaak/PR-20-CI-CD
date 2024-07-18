package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStepDef {

    ApiPage apiPage;

    public ApiStepDef() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit API get list users")
    public void hitAPIGetListUsers() {
        apiPage.hitAPIGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        apiPage.validationStatusCodeIsEquals(statusCode);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String fileName) {
        apiPage.validationResponseJsonWithJSONSchema(fileName);
    }

    @And("prepare valid id {int}")
    public void prepareValidId(int user_id) {
        apiPage.prepareValidId(user_id);
    }

    @And("hit API get user by id")
    public void hitAPIGetUserById() {
        apiPage.hitAPIGetUserById();
    }

    @Then("validation response body get user by id")
    public void validationResponseBodyGetUserById() {
        apiPage.validationResponseBodyGetUserById();
    }

    @And("hit api get data wrong id")
    public void hitApiGetDataWrongId() {
        apiPage.hitApiGetDataWrongId();
    }

    @Then("validation response body wrong id")
    public void validationResponseBodyWrongId() {
        apiPage.validationResponseBodyWrongId();
    }

    @And("hit API get list user with name {string}")
    public void hitAPIGetListUserWithName(String name) {
        apiPage.hitAPIGetListUsersWithParams(name);
    }

    @And("validate data user name should be contain {string}")
    public void validateDataUserNameShouldBeContain(String name) {
        apiPage.validateDataUserNameShouldBeContain(name);
    }
}
