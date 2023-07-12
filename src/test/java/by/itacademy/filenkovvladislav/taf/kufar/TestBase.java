package by.itacademy.filenkovvladislav.taf.kufar;

import by.itacademy.filenkovvladislav.taf.kufar.pages.PageUI;
import by.itacademy.filenkovvladislav.taf.kufar.steps.StepUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected PageUI page;
    protected StepUI step;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        page = new PageUI(driver);
        step = new StepUI(driver);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        step.preparatoryActions();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}