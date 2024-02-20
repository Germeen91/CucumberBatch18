package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;



//objective repository
//POM( page object model) ... design pattern
//page factory with @findBy annotation
public class EmployeeSearchPage extends CommonMethods {// extends from commonMethods to avoid red error driver in factorPage
// page object model design pattern  OR  class object repository. (encapsulation concept)
    // Here we have all Locators related login

    @FindBy(id = "empsearch_id")
    public WebElement empIdLoc;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement empNameLoc;

    @FindBy(id = "searchBtn")
    public WebElement searchOption;

    public EmployeeSearchPage() {
        PageFactory.initElements(driver, this);
    }
}
