package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.DriverSetup;

import java.util.List;

public class SearchFunctionalityPage extends BasePage {
    @FindBy(xpath = "//mat-icon[normalize-space()='search']")
    WebElement searchIcon;
    @FindBy(id = "mat-input-0")
    WebElement searchField;
    @FindBy(xpath = "//div[normalize-space()='Apple Juice (1000ml)']")
    WebElement appleJuiceItem;
    @FindBy(xpath = "//div[normalize-space()='Apple Pomace']")
    WebElement applePomaceItem;
    @FindBy(xpath = "//div[normalize-space()='Banana Juice (1000ml)']")
    List<WebElement> bananaJuiceItem;

    public SearchFunctionalityPage() {
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    public void searching(String searchTerm) {
        searchIcon.click();
        searchField.sendKeys(searchTerm);
        manualWaiting(3000);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searchingAndValidatingItem() {
        //searching the item
        searching("apple");

        //checking the visibility of the item element
        presenceOfElement(appleJuiceItem);

        //verifying 2 apple product is available
        Assert.assertEquals(appleJuiceItem.getText(), "Apple Juice (1000ml)");
        Assert.assertEquals(applePomaceItem.getText(), "Apple Pomace");

        // turning off implicit wait so that when verifying an element is not present, can be faster. the page is loaded already
        turnOffImplicitWait();

        //verifying banana is not available
        Assert.assertEquals(bananaJuiceItem.size(), 0);

        //turning on implicit wait for next tests
        turnOnImplicitWait();
    }
}
