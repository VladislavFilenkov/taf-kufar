package by.itacademy.filenkovvladislav.taf.kufar;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class KufarPage {
    private WebDriver driver;
    String baseUrl = "https://www.kufar.by/";
    String buttonCookieByXpath = "//div[@class='styles_buttons__ji_e6']/button";
    String buttonLoginByXpath = "//div[@data-testid='login_button']/button";
    String inputLoginById = "login";
    String inputPasswordById = "password";
    String buttonSubmitByXpath = "//div[@data-name='login_submit']/button";
    String iframePopUpByXpath = "/html/body/div[3]/div/div[3]/div/div/iframe";
    String buttonClosePopUpById = "control__close";

    public KufarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebSite() {
        driver.get(baseUrl);
    }

    public void clickButtonLogin() {
        driver.findElement(By.xpath(buttonLoginByXpath)).click();
    }

    public void inputLogin(String email) {
        driver.findElement(By.id(inputLoginById)).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(By.id(inputPasswordById)).sendKeys(password);
    }

    public void clickButtonSubmit() {
        driver.findElement(By.xpath(buttonSubmitByXpath)).click();
    }

    public void closeCookie() {
        driver.findElement(By.xpath(buttonCookieByXpath)).click();
    }

    public void closePopUp() {
        List<WebElement> iframeElements = driver.findElements(By.xpath(iframePopUpByXpath));
        if (!iframeElements.isEmpty()) {
            WebElement iframeElement = iframeElements.get(0);
            if (iframeElement.isDisplayed()) {
                driver.switchTo().frame(iframeElement);
                WebElement closeButton = driver.findElement(By.id(buttonClosePopUpById));
                closeButton.click();
                driver.switchTo().defaultContent();
            }
        }
    }
}

