package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIWorkFlowSteps {

    String baseURI = RestAssured.baseURI
            ="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;
    Response response;
    RequestSpecification request;
    public static String employee_id;
    @Given("a JWT bearer token is created")
    public void a_jwt_bearer_token_is_created() {
      //prepare the request
        RequestSpecification request= given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).

                body("{\n" +
                        "  \"email\": \"GodIsLove@gmail.com\",\n" +
                        "  \"password\": \"GodIsLove123?\"\n" +
                        "}");

        // hit the endpoint/send the request
        Response response=request.when().post(APIConstants.GENERATE_TOKEN);
        //save the token in token variable
        token="Bearer "+ response.jsonPath().getString("token");
        System.out.println(token);
    }
    @Given("a request is prepared to create an employee using api call")
    public void a_request_is_prepared_to_create_an_employee_using_api_call() {
         request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).

                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body("{\n" +
                        "  \"emp_firstname\": \"Marco\",\n" +
                        "  \"emp_lastname\": \"Philip\",\n" +
                        "  \"emp_middle_name\": \"BB\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-10-09\",\n" +
                        "  \"emp_status\": \"Temporary\",\n" +
                        "  \"emp_job_title\": \"IT\"\n" +
                        "}");
    }
    @When("a POST call is made to create the employee")
    public void a_post_call_is_made_to_create_the_employee() {
         response= request.when().post(APIConstants.CREATE_EMPLOYEE);
    }
    @Then("the status for this request should be {int}")
    public void the_status_for_this_request_should_be(Integer status) {
        response.then().assertThat().statusCode(status);
        response.prettyPrint();
    }

    @Then("the employee created contains key {string} and value {string}")
    public void the_employee_created_contains_key_and_value(String key, String value) {
        response.then().assertThat().body(key,equalTo(value));

    }
    @Then("the employee id {string} is stored as global variable")
    public void the_employee_id_is_stored_as_global_variable(String employeeId) {
        employee_id=  response.jsonPath().getString(employeeId);
        System.out.println(employee_id);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Given("a request is prepared to get the created employee")
    public void a_request_is_prepared_to_get_the_created_employee() {
        request=given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).queryParam("employee_id",employee_id);
    }
    @When("a GET call is made to retrieve the employee")
    public void a_get_call_is_made_to_retrieve_the_employee() {
        response=request.when().get(APIConstants.GET_ONE_EMPLOYEE);
    }
    @Then("the status code for this  get request is {int}")
    public void the_status_code_for_this_get_request_is(Integer status) {
        response.then().assertThat().statusCode(status);
        response.prettyPrint();
    }
    @Then("the employee has ID {string} must match with global emp id")
    public void the_employee_has_id_must_match_with_global_emp_id(String empID) {
        String temporaryEmpID =
                response.jsonPath().getString(empID);
//here we are comparing both emp id's from get and post call
        Assert.assertEquals(temporaryEmpID,employee_id);
    }

    @Then("the data coming from {string} object should match with the data used in post")
    public void the_data_coming_from_object_should_match_with_the_data_used_in_post
            (String empObject, io.cucumber.datatable.DataTable dataTable) {
//data coming from feature file will be stored here
        List<Map<String,String>> expectedData = dataTable.asMaps();
        //data will be taken up from the response from employee object
        Map<String,String> actualData = response.jsonPath().get(empObject);  // getString to get one string

        //this is the time to compare the values
        for (Map<String,String> map:expectedData
        ) {
            //to get all the keys which are unique
            Set<String> keys   = map.keySet(); // getKey to get one key only
            for (String key:keys
            ) {
                //this values one by one coming from feature file
                String expectedValue = map.get(key);
                //this value one by one coming from response i.e employee object
                String actualValue = actualData.get(key);
                Assert.assertEquals(actualValue, expectedValue);
            }
        }




    }















}