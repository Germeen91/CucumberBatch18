package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.ConfigReader;


//objective repository
//POM( page object model) ... design pattern
//page factory with @findBy annotation

public class LoginPage extends CommonMethods {
// page object model design pattern  OR  class object repository. (encapsulation concept)
    // Here we have all Locators related login
    @FindBy(id="txtUsername")
    public WebElement usernameField;

    @FindBy(id="txtPassword")
    public WebElement passwordField;

    @FindBy(xpath="//*[@id='btnLogin']")
    public WebElement loginButton;

    //  @FindBy(xpath="//*[@id='btnLogin']")
    //    public List<WebElement> loginButton;

    @FindBy(id="spanMessage")
    public WebElement errorMessageLoc;


    //Extra Ways
    public void enterUsername(){
        sendText(ConfigReader.read("username"),login.usernameField);
    }

    public void enterPassword(){
        sendText(ConfigReader.read("password"),login.passwordField);
    }

    public void clickLoginButton(){
click(login.loginButton);
    }



    public LoginPage(){    // constructor
        //page factory we use to initialize all the web elements and driver we pass as
        // an argument to it. this keyword means, we need to initialize all the elements
        // of this local class
        PageFactory.initElements(driver,this);
    }







}
