package by.itacademy.filenkovvladislav.taf.kufar.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        return driver;
    }

    private DriverSingleton() {
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
