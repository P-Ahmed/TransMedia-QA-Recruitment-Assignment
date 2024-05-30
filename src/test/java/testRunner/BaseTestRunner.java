package testRunner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.DriverSetup;
import utils.Utility;

public class BaseTestRunner {
    @BeforeTest
    public void browserSetupUsingConfigProperties() {
        DriverSetup.setThreadDriverName(Utility.readThePropertyFile("browser"));
    }

    @AfterTest
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
