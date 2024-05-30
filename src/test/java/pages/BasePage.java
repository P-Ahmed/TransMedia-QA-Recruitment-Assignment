package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSetup;

import java.time.Duration;

public class BasePage {
    public WebDriverWait wait = new WebDriverWait(DriverSetup.getDriver(), Duration.ofSeconds(5));

    public void presenceOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void turnOffImplicitWait() {
        DriverSetup.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    public void turnOnImplicitWait() {
        DriverSetup.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void clickAndType(WebElement webElementForClicking, WebElement webElementForTyping, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(webElementForClicking)).click();
        webElementForTyping.sendKeys(text);
    }

    public void manualWaiting(int timeInMilliSeconds) {
        try {
            Thread.sleep(timeInMilliSeconds);
        } catch (Exception e) {
            System.out.println("Time related exception: " + e);
        }
    }
}
