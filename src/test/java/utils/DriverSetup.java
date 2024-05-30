package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverSetup {
    //To ensure that each thread in a multi-threaded environment (like in parallel testing) has its own instance of WebDriver.
    //This prevents issues that arise from sharing the same WebDriver instance across multiple threads, such as concurrency problems and data corruption.
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    //To store and manage any additional information about the WebDriver instance in a thread-safe manner.
    //For example, the type or name of the driver (like "chrome", "firefox", etc.) used by each thread can
    //be stored here, ensuring that this information is specific to each thread.
    private static final ThreadLocal<String> threadDriverName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (threadDriver.get() == null) {
            if (threadDriverName.get() == null) {
                threadDriverName.set("chrome");
            }
            switch (threadDriverName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    threadDriver.get().manage().window().maximize();
                    threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    break;
                case "safari":
                    threadDriver.set(new SafariDriver());
                    threadDriver.get().manage().window().maximize();
                    threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    threadDriver.get().manage().window().maximize();
                    threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    break;
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();

                    chromeOptions.addArguments("--headed");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--disable-software-rasterizer");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--no-sandbox");

                    threadDriver.set(new ChromeDriver(chromeOptions));
                    threadDriver.get().manage().window().maximize();
                    threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            }
        }
        return threadDriver.get();
    }

    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }

    public static void setThreadDriverName(String browserName) {
        threadDriverName.set(browserName);
    }
}
