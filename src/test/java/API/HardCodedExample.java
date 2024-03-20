package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExample {


    String baseURI = RestAssured.baseURI     // uri =url  get it from swagger document
            ="http://hrm.syntaxtechs.net/syntaxapi/api";   // do not forget http

    static String employee_id;
    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTA4NjkyODIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxMDkxMjQ4MiwidXNlcklkIjoiNjQ0MCJ9.9yzZnrZHBGxH9J9HPJp96x7Tuk-VukIKagwFFo9UWCM";





    @Test            // test from junit parent
    public void acreateEmployee(){

        //it will create the request

        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"emp_firstname\": \"Marco\",\n" +
                        "  \"emp_lastname\": \"Philip\",\n" +
                        "  \"emp_middle_name\": \"BB\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-10-09\",\n" +
                        "  \"emp_status\": \"Temporary\",\n" +
                        "  \"emp_job_title\": \"IT\"\n" +
                        "}");

        // it will give us the response after hitting the endpoint
      Response response= request.when().post("/createEmployee.php");

        //assert that is the method we use to validate the response
      response.then().assertThat().statusCode(201);

      // this method is used to print the response in console
        response.prettyPrint();


//hamcrest matchers  [equal import from core hamcrest ] ..this is the class which contains method to perform assertions
       response.then().assertThat().body("Message",equalTo("Employee Created"));
response.then().assertThat().body("Employee.emp_firstname",equalTo("Marco"));
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Philip"));
        response.then().assertThat().header("Connection",equalTo("Keep-Alive"));// from response header at postman console after we send request will get on console response header

// to fetch the employee id from response body ,we need response variable
      employee_id=  response.jsonPath().getString("Employee.employee_id"); // global variable
                     //jsonPath >>is a class  help us to use   jsonPath() methods to get key and value from body
    }


@Test
    public void bgetCreateEmployee(){  // all info from swagger
// prepare the request
       RequestSpecification request=given().
               header("Content-Type","application/json").
               header("Authorization",token).queryParam("employee_id",employee_id);

// hitting the endpoint
        Response response=request.when().get("/getOneEmployee.php");

        // validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();


String temporaryEmpID =
        response.jsonPath().getString("employee.employee_id");
//here we are comparing both emp id's from get and post call
    Assert.assertEquals(temporaryEmpID,employee_id);
    //validate the body from get call
    response.then().assertThat().body("employee.emp_firstname",equalTo("Marco"));
    response.then().assertThat().body("employee.emp_lastname",equalTo("Philip"));

    }


    @Test
    public void cUpdateEmployee(){
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Gogaa\",\n" +
                        "  \"emp_lastname\": \"Alfred\",\n" +
                        "  \"emp_middle_name\": \"ME\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2000-10-10\",\n" +
                        "  \"emp_status\": \"Permenant\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");


        // hitting the endpoint
        Response response=request.when().put("/updateEmployee.php");

        // validate the response
        response.then().assertThat().statusCode(200);

        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
        response.prettyPrint();

    }


    @Test
    public void dGetUpdatedEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);



        // hitting the endpoint
        Response response=request.when().get("/getOneEmployee.php");
        response.prettyPrint();

        // validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

    }


    @Test
    public void eGetJobTitle(){

        //prepare the request
        RequestSpecification request=given().
                header("Content-Type","application/json").
                header("Authorization",token);

// hitting the endpoint

        Response response=request.when().get("/jobTitle.php");
        // validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void fGetAllEmployee(){
        //prepare request
        RequestSpecification request=given().
                header("Content-Type","application/json").
                header("Authorization",token);

    //hitting endpoint
        Response response=request.when().get("/getAllEmployees.php");

        // validate the response
        response.then().assertThat().statusCode(200);
        response.jsonPath();
    }



    @Test
    public void gGetAllEmploymentStatus(){
        //prepare request
        RequestSpecification request=given().
                header("Content-Type","application/json").
                header("Authorization",token);
        // hitting the endpoint
        Response response=request.when().get("/employeementStatus.php");
        //validate
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void hUpdatePartialEmployeeDetails(){
        RequestSpecification request=given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_middle_name\": \"PO\",\n" +
                        "  \"emp_status\": \"Tired\",\n" +
                        "  \"emp_job_title\": \"Coocker\"\n" +
                        "}");

        Response response=request.when().patch("/updatePartialEmplyeesDetails.php");

        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message",equalTo("Employee record updated successfully"));
        response.then().assertThat().body("employee.emp_firstname",equalTo("Gogaa"));
        String IdTemporary=response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(IdTemporary,employee_id);

response.prettyPrint();
    }

}
