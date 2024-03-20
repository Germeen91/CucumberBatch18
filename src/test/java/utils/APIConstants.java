package utils;

import io.restassured.RestAssured;

public class APIConstants {

public static final String baseURI = RestAssured.baseURI
        ="http://hrm.syntaxtechs.net/syntaxapi/api";



public static final String CREATE_EMPLOYEE = baseURI + "/createEmployee.php";
    public static final String GENERATE_TOKEN = baseURI + "/generateToken.php";
    public static final String GET_ONE_EMPLOYEE = baseURI + "/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE = baseURI +"/updateEmployee.php";

    public static final String GET_ALL_EMPLOYEE = baseURI +"/getAllEmployees.php";
    public static final String GET_JOB_TITLE = baseURI +"/jobTitle.php";
    public static final String GET_EMPLOYMENT_STATUS = baseURI +"/employeementStatus.php";
    public static final String DELETE_EMPLOYEE = baseURI +"/deleteEmployee.php";
    public static final String UPDATE_PARTIAL_EMPLOYEE = baseURI +"/updatePartialEmplyeesDetails.php";



    public static final String HEADER_CONTENT_TYPE_KEY = "Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE = "application/json";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";



}
