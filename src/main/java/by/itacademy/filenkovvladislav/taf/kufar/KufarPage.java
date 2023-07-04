package by.itacademy.filenkovvladislav.taf.kufar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KufarPage {
    private WebDriver driver;
    String baseUrl = "https://www.kufar.by/";
    String buttonCookieByXpath = "//button[@class = 'styles_button__2lS9d styles_secondary__e06Fh styles_submit_button__0D660' and text() = 'Принять']";
    String buttonPopUpById = "control__close";
    String buttonLoginByXpath = "//button[@class = 'styles_button__2lS9d styles_outline__j5ujQ' and text() = 'Войти']";
    String inputLoginById = "login";
    String inputPasswordById = "password";
    String buttonSubmitByXpath = "//button[@class = 'styles_button__2lS9d styles_default__vR5R7 styles_block__g1Ijk' and text() = 'Войти']";

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@scrolling='no' and style='min-height: 100%; height: 100%; min-width: 100%; width: 1px;']"));

        driver.switchTo().frame(iframeElement);

        WebElement adPopupElement = driver.findElement(By.id("banner"));

        if (adPopupElement.isDisplayed()) {
            WebElement closeButton = driver.findElement(By.id("control__close"));
            closeButton.click();
        } else {
            driver.switchTo().defaultContent();
        }
    }
}

