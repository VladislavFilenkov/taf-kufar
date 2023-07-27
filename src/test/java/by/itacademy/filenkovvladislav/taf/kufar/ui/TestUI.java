package by.itacademy.filenkovvladislav.taf.kufar.ui;

import by.itacademy.filenkovvladislav.taf.kufar.alerts.Alerts;
import by.itacademy.filenkovvladislav.taf.kufar.domain.User;
import by.itacademy.filenkovvladislav.taf.kufar.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUI extends TestBase {

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        page.clickButtonSubmit();
        Assertions.assertEquals(Alerts.emptyEmail, page.getAlertText(page.alertEmptyEmailByXpath));
        Assertions.assertEquals(Alerts.emptyPassword, page.getAlertText(page.alertEmptyPasswordByXpath));
    }

    @Test
    public void testLoginWithIncorrectEmailAndAnyPassword() {
        step.fillLoginForm(User.INCORRECT_EMAIL, User.PASSWORD);
        Assertions.assertEquals(Alerts.incorrectEmail, page.getAlertText(page.alertIncorrectEmailByXpath));
    }

    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        step.fillLoginFormAndSubmit(Util.correctEmail(), Util.anyPassword());
        page.clickButtonSubmit();
        Assertions.assertEquals(Alerts.noCombination, page.getAlertText(page.alertNoCombinationByXpath));
    }
}
