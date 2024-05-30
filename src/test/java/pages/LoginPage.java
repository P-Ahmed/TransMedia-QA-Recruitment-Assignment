package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSetup;
import utils.Utility;

import java.util.List;

public class LoginPage extends BasePage {
    @FindBy(css = "button[aria-label='Close Welcome Banner']")
    WebElement closingWelcomeBanner;
    @FindBy(id = "navbarAccount")
    WebElement navAccountButton;
    @FindBy(id = "navbarLoginButton")
    WebElement navLoginButton;
    @FindBy(xpath = "//a[normalize-space()='Not yet a customer?']")
    WebElement notYetCustomerLink;

    @FindBy(id = "emailControl")
    WebElement registrationEmailField;
    @FindBy(id = "passwordControl")
    WebElement registrationPasswordField;
    @FindBy(id = "repeatPasswordControl")
    WebElement registrationRepeatPasswordField;
    @FindBy(name = "securityQuestion")
    WebElement secretQuestionDropdown;
    @FindBy(xpath = "//span[normalize-space()='Your eldest siblings middle name?']")
    WebElement secretQuestion;
    @FindBy(id = "securityAnswerControl")
    WebElement secretQuestionAnswerField;
    @FindBy(id = "registerButton")
    WebElement registerButton;

    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "loginButton")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    public void doRegistration() {
        // creating random email and password
        Utility.randomInfoGeneration();

        //going to the website url
        DriverSetup.getDriver().get(Utility.readThePropertyFile("Url"));

        //navigating to registration page
        closingWelcomeBanner.click();
        navAccountButton.click();
        navLoginButton.click();
        notYetCustomerLink.click();

        //completing user registration
        registrationEmailField.sendKeys(Utility.readThePropertyFile("RandomEmail"));
        registrationPasswordField.sendKeys(Utility.readThePropertyFile("RandomPassword"));
        registrationRepeatPasswordField.sendKeys(Utility.readThePropertyFile("RandomPassword"));
        manualWaiting(3000);
        secretQuestionDropdown.click();
        secretQuestion.click();
        secretQuestionAnswerField.sendKeys(Utility.readThePropertyFile("SecretAnswer"));
        registerButton.click();
    }

    public void doLogin() {
        //user login, getting credentials from config.properties
        emailField.sendKeys(Utility.readThePropertyFile("RandomEmail"));
        passwordField.sendKeys(Utility.readThePropertyFile("RandomPassword"));
        loginButton.click();
    }
}
