package by.itacademy.filenkovvladislav.taf.kufar.pages;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class PageAPI {
    public String signInUrl = "https://www.kufar.by/l/api/login/v2/auth/signin";
    public String homeUrl = "https://www.kufar.by/l";
    public String searchResult = "Оригинальные кроссовки Adidas Ultra 4d";
    public String searchSelector = "img[data-src='https://rms.kufar.by/v1/list_thumbs_2x/adim1/f2e24245-e1a1-4983-830d-6cc001430393.jpg']";

    public String loginFormBody(String email, String password) {
        return "{\"password\":\"" + password + "\", " +
                "\"login\":\"" + email + "\"}";
    }

    public HashMap<String, String> queryParamsSignIn() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("token_type", "user");
        return queryParams;
    }

    public HashMap<String, String> queryParamsSearch(String search) {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("query", search);
        queryParams.put("rgn", "all");
        queryParams.put("utm_queryOrigin", "Manually_typed");
        return queryParams;
    }

    public ValidatableResponse performLogin(String email, String password) {
        return given().when().header("Content-Type", "application/json")
                .queryParams(queryParamsSignIn())
                .body(loginFormBody(email, password))
                .post(signInUrl).then();
    }

    public ValidatableResponse searchQuery(String searchWord) {
        return given().when().queryParams(queryParamsSearch(searchWord))
                .get(homeUrl).then();
    }

    public String getAlertText(ValidatableResponse response) {
        JsonPath jsonPath = response.extract().jsonPath();
        return jsonPath.getString("label.text");
    }

    public String getSearchText(ValidatableResponse response) {
        String htmlResponse = response.extract().asString();
        Document document = Jsoup.parse(htmlResponse);
        Element imgElement = document.selectFirst(searchSelector);
        return imgElement.attr("alt");
    }
}
