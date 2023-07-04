package by.itacademy.filenkovvladislav.taf.kufar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class KufarTestUI {
    ChromeDriver driver;
    KufarPage page;
    KufarStep step;
    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        page = new KufarPage(driver);
        step = new KufarStep(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        step.preparatoryActions();
    }
    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit("test@mail.com", "asdfg234");
    }
    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
