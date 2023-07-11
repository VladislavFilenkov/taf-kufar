package by.itacademy.filenkovvladislav.taf.kufar.steps;

import by.itacademy.filenkovvladislav.taf.kufar.pages.PageUI;
import org.openqa.selenium.WebDriver;


public class StepUI {
    PageUI page;

    public StepUI(WebDriver driver) {
        page = new PageUI(driver);
    }

    public void preparatoryActions() {
        page.openWebSite();
        page.closeCookie();
        page.closePopUp();
        page.clickButtonLogin();
    }

    public void fillLoginForm(String email, String password) {
        page.inputLogin(email);
        page.inputPassword(password);
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        page.inputLogin(email);
        page.inputPassword(password);
        page.clickButtonSubmit();
    }

}
