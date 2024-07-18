Feature: Test Automation GoRest API

  @api
  Scenario: Test get list data user
    Given prepare url for "GET_LIST_USERS"
    And hit API get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users.json"

  @api
  Scenario: Test get list data user invalid endpoint
    Given prepare url for "GET_ENDPOINT_WRONG"
    And hit API get list users
    Then validation status code is equals 404

  @api
  Scenario: Test get data user by id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id 7028415
    And hit API get user by id
    Then validation status code is equals 200
    Then validation response body get user by id
    Then validation response json with JSONSchema "get_user_by_id.json"

  @api
  Scenario: Test get data wrong id
    Given prepare url for "GET_DATA_WRONG_ID"
    And hit api get data wrong id
    Then validation status code is equals 404
    Then validation response body wrong id

  @api
  Scenario: Test get data invalid id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id 69581364
    And hit API get user by id
    Then validation status code is equals 404
    Then validation response body wrong id

  @api
  Scenario Outline: Test get user with parameter name
    Given prepare url for "GET_LIST_USERS"
    And hit API get list user with name "<name>"
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_users.json"
    And validate data user name should be contain "<name>"

    Examples:
      |name  |
      |Talwar   |
