package utils;

import pages.*;

public class PageInitializer {


    public static LoginPage login;  //like webDriver to avoid NullPointerException

public static DashboardPage dashboardPage;

public static AddEmployeePage addEmployeePage;
    public static EmployeeDetailsPage employeeDetailsPage;
    public  static EmployeeSearchPage employeeSearchPage;

    public static void initializePageObjects(){
        login = new LoginPage();
        dashboardPage = new DashboardPage();
addEmployeePage = new AddEmployeePage();
employeeSearchPage =new EmployeeSearchPage();
        employeeDetailsPage=new EmployeeDetailsPage();

    }
}
