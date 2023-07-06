package by.itacademy.filenkovvladislav.taf.kufar;

import by.itacademy.filenkovvladislav.taf.kufar.pages.Page;
import by.itacademy.filenkovvladislav.taf.kufar.steps.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;
    protected Page page;
    protected Step step;


    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        page = new Page(driver);
        step = new Step(driver);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        step.preparatoryActions();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
