package by.itacademy.filenkovvladislav.taf.kufar;
import org.openqa.selenium.WebDriver;


public class KufarStep {
    KufarPage page;

    public KufarStep(WebDriver driver) {
        page = new KufarPage(driver);
    }
    public void preparatoryActions() {
        page.openWebSite();
        page.closeCookie();
        page.closePopUp();
        page.clickButtonLogin();
    }
    public void fillLoginFormAndSubmit(String email, String password) {
        page.inputLogin(email);
        page.inputPassword(password);
        page.clickButtonSubmit();
    }

}
