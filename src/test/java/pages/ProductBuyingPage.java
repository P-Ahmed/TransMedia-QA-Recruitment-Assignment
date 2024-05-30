package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSetup;

import java.util.List;

public class ProductBuyingPage extends BasePage {
    @FindBy(css = "button[aria-label='Add to Basket']")
    List<WebElement> addToBasketButton;
    @FindBy(xpath = "//button[@aria-label='Show the shopping cart']")
    WebElement yourBasketButton;
    @FindBy(xpath = "//mat-cell[normalize-space()='Apple Pomace']")
    WebElement itemNameInTheBasket;
    @FindBy(id = "checkoutButton")
    WebElement checkoutButton;

    @FindBy(xpath = "//button[@aria-label='Add a new address']")
    WebElement addNewAddressButton;
    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c21-25']")
    WebElement getCountryField;
    @FindBy(css = "input[placeholder='Please provide a country.']")
    WebElement countryField;
    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c21-26']")
    WebElement getNameField;
    @FindBy(css = "input[placeholder='Please provide a name.']")
    WebElement nameField;
    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c21-27']")
    WebElement getMobileNumberField;
    @FindBy(css = "input[placeholder='Please provide a mobile number.']")
    WebElement mobileNumberField;
    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c21-28']")
    WebElement getZipCodeField;
    @FindBy(css = "input[placeholder='Please provide a ZIP code.']")
    WebElement zipCodeField;
    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c21-29']")
    WebElement getAddressTextArea;
    @FindBy(css = "textarea[placeholder='Please provide an address.']")
    WebElement addressTextArea;
    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c21-30']")
    WebElement getCityField;
    @FindBy(css = "input[placeholder='Please provide a city.']")
    WebElement cityField;
    @FindBy(id = "submitButton")
    WebElement submitButton;

    public ProductBuyingPage() {
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    public void addingToBasket() {
        //adding a product to the basket
        addToBasketButton.get(1).click();

        //waiting for the product to be added in the basket
        manualWaiting(3000);

        //navigating to the basket to check out
        yourBasketButton.click();
        presenceOfElement(itemNameInTheBasket);
        presenceOfElement(checkoutButton);
        checkoutButton.click();
    }

    public void addingNewAddress() {
        addNewAddressButton.click();

        //clicking on the field first for enabling typing. clicking and typing both needs different element
        clickAndType(getCountryField, countryField, "Bangladesh");
        clickAndType(getNameField, nameField, "Pollab");
        clickAndType(getMobileNumberField, mobileNumberField, "01948563837");
        clickAndType(getZipCodeField, zipCodeField, "1236");
        clickAndType(getAddressTextArea, addressTextArea, "South Donia");
        clickAndType(getCityField, cityField, "Dhaka");
        submitButton.click();
    }
}
