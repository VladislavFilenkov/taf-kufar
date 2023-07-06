package by.itacademy.filenkovvladislav.taf.kufar;

import by.itacademy.filenkovvladislav.taf.kufar.alerts.Alerts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUI extends TestBase {

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        page.clickButtonSubmit();
        Assertions.assertEquals(page.getAlertText(page.alertEmptyEmailByXpath), Alerts.alertEmptyEmail);
        Assertions.assertEquals(page.getAlertText(page.alertEmptyPasswordByXpath), Alerts.alertEmptyPassword);
    }

    @Test
    public void testLoginWithIncorrectEmailAndAnyPassword() {
        step.fillLoginForm("email", "asdfg234");
        Assertions.assertEquals(page.getAlertText(page.alertIncorrectEmailByXpath), Alerts.alertIncorrectEmail);
    }

    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit("test1212@mail.com", "asdfg234");
        Assertions.assertEquals(page.getAlertText(page.alertNoCombinationByXpath), Alerts.alertNoCombination);
    }
}
