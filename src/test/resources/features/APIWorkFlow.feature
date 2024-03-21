Feature: API workflow
Background:
  Given a JWT bearer token is created

  @api
  Scenario: create the employee from framework with rest assured
    Given a request is prepared to create an employee using api call
    When a POST call is made to create the employee
    Then the status for this request should be 201
    And  the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global variable


    @api
    Scenario: Get the created employee
      Given a request is prepared to get the created employee
      When  a GET call is made to retrieve the employee
      Then the status code for this  get request is 200
      And the employee has ID "employee.employee_id" must match with global emp id
      And the data coming from "employee" object should match with the data used in post
        |emp_firstname|emp_middle_name|  emp_lastname|emp_birthday |emp_gender|emp_job_title| emp_status|
        |Marco        |   BB          |    Philip    | 2000-10-09  |  Male    | IT          | temporary |
      # employee object From response body [result]

  @json
  Scenario: Create employee using json payload
    Given  a request is prepared to create an employee using json payload
    When a POST call is made to create the employee
    Then the status for this request should be 201
    And  the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global variable

    @dynamic
    Scenario: Create employee using more dynamic json payload
      Given a request is prepared using data "Marco","Philip","BB","M","2000-10-09","Temporary","IT"
      When a POST call is made to create the employee
      Then the status for this request should be 201
      And  the employee created contains key "Message" and value "Employee Created"
      And the employee id "Employee.employee_id" is stored as global variable
