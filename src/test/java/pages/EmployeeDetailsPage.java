package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeDetailsPage extends CommonMethods {

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;


    @FindBy(id = "btnSave")
    public WebElement editButton;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement firstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement middleName;

    @FindBy(id = "personal_txtEmpLastName")
    public WebElement lastName;

    @FindBy(id = "personal_optGender_2")
    public WebElement genderSelect;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    public WebElement Male;

    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    public WebElement Female;


    @FindBy(id = "personal_cmbNation")
    public WebElement nationalityInput;

    @FindBy(id = "personal_cmbMarital")
    public WebElement maritalStatusSelect;

    @FindBy(id = "btnSave")
    public WebElement save;


    public EmployeeDetailsPage(){
        PageFactory.initElements(driver,this);
    }
}



