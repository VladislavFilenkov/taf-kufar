package by.itacademy.filenkovvladislav.taf.kufar.api;

import by.itacademy.filenkovvladislav.taf.kufar.alerts.Alerts;
import by.itacademy.filenkovvladislav.taf.kufar.domain.User;
import by.itacademy.filenkovvladislav.taf.kufar.pages.PageAPI;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAPI {
    PageAPI page = new PageAPI();

    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        ValidatableResponse response = page.performLogin(User.CORRECT_EMAIL, User.PASSWORD);
        Assertions.assertEquals(401, page.getStatusCode(response));
        Assertions.assertEquals(Alerts.noCombination, page.getAlertText(response));
    }

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        ValidatableResponse response = page.performLogin("", "");
        Assertions.assertEquals(400, page.getStatusCode(response));
        Assertions.assertEquals(Alerts.emptyOrIncorrectLoginForm, page.getAlertText(response));
    }

    @Test
    public void testSearch() {
        ValidatableResponse response = page.searchQuery("acronim");
        Assertions.assertEquals(200, page.getStatusCode(response));
        Assertions.assertEquals(page.searchResult, page.getSearchText(response));
    }
}
