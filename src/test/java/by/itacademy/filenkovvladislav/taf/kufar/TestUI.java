package by.itacademy.filenkovvladislav.taf.kufar;

import by.itacademy.filenkovvladislav.taf.kufar.alerts.Alerts;
import by.itacademy.filenkovvladislav.taf.kufar.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUI extends TestBase {

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        page.clickButtonSubmit();
        Assertions.assertEquals(page.getAlertText(page.alertEmptyEmailByXpath), Alerts.emptyEmail);
        Assertions.assertEquals(page.getAlertText(page.alertEmptyPasswordByXpath), Alerts.emptyPassword);
    }

    @Test
    public void testLoginWithIncorrectEmailAndAnyPassword() {
        step.fillLoginForm(Util.incorrectEmail(), Util.anyPassword());
        Assertions.assertEquals(page.getAlertText(page.alertIncorrectEmailByXpath), Alerts.incorrectEmail);
    }

    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit(Util.correctEmail(), Util.anyPassword());
        Assertions.assertEquals(page.getAlertText(page.alertNoCombinationByXpath), Alerts.noCombination);
    }
}
