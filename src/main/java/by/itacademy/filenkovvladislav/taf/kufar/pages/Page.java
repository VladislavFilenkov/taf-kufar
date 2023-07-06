package by.itacademy.filenkovvladislav.taf.kufar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Page {
    private WebDriver driver;
    private String baseUrl = "https://www.kufar.by/";
    private String buttonCookieByXpath = "//div[@class='styles_buttons__ji_e6']/button";
    private String buttonLoginByXpath = "//div[@data-testid='login_button']/button";
    private String inputLoginById = "login";
    private String inputPasswordById = "password";
    private String buttonSubmitByXpath = "//div[@data-name='login_submit']/button";
    private String iframePopUpByXpath = "/html/body/div[3]/div/div[3]/div/div/iframe";
    private String buttonClosePopUpById = "control__close";
    public String alertEmptyEmailByXpath = "//div[text()='Заполните обязательное поле']";
    public String alertIncorrectEmailByXpath = "//div[text()='Проверьте введенный email - неправильный формат']";
    public String alertEmptyPasswordByXpath = "//div[text()='Введите пароль']";
    public String alertNoCombinationByXpath = "//p[text()='Введен неверный пароль либо такого профиля не существует']";

    public Page(WebDriver driver) {
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

