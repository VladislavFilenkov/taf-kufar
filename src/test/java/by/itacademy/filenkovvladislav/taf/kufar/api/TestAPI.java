package by.itacademy.filenkovvladislav.taf.kufar.api;

import by.itacademy.filenkovvladislav.taf.kufar.alerts.Alerts;
import by.itacademy.filenkovvladislav.taf.kufar.pages.PageAPI;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAPI {
    PageAPI page = new PageAPI();

    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        ValidatableResponse response = page.performLogin("test2342@test.com", "f22f2f");
        Assertions.assertEquals(Alerts.noCombination, page.getAlertText(response));
    }

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        ValidatableResponse response = page.performLogin("", "");
        Assertions.assertEquals(Alerts.emptyOrIncorrectLoginForm, page.getAlertText(response));
    }

    @Test
    public void testSearchAdidas() {
        ValidatableResponse response = page.searchQuery("adidas");
        Assertions.assertEquals(page.searchResult, page.getSearchText(response));

    }
}
