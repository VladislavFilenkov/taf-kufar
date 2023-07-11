package by.itacademy.filenkovvladislav.taf.kufar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUI extends LocatorsUI {
    private final WebDriver driver;

    public PageUI(WebDriver driver) {
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

    public String getAlertText(String locator) {
        WebElement alertText = driver.findElement(By.xpath(locator));
        return alertText.getText();
    }

    public void closePopUp() {
        try {
            WebElement iframeElement = driver.findElement(By.xpath(iframePopUpByXpath));
            driver.switchTo().frame(iframeElement);
            WebElement closeButton = driver.findElement(By.id(buttonClosePopUpById));
            closeButton.click();
            driver.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
        }
    }
}

