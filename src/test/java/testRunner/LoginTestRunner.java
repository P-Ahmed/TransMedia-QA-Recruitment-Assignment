package testRunner;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends BaseTestRunner {
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1)
    public void userRegistration() {
        loginPage.doRegistration();
    }

    @Test(priority = 2)
    public void userLogin() {
        loginPage.doLogin();
    }
}
