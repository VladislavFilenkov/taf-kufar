package by.itacademy.filenkovvladislav.taf.kufar.pages;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class PageAPI {
    private String signInUrl = "https://www.kufar.by/l/api/login/v2/auth/signin";
    private String homeUrl = "https://www.kufar.by/l";
    public String searchResult = "ветровка adidas";
    private String searchSelector = "h3.styles_title__F3uIe:contains(" + searchResult + ")";


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
        Elements elements = document.select(searchSelector);
        Element element = elements.get(0);
        return element.text();
    }
    public int getStatusCode(ValidatableResponse response){
        return response.extract().statusCode();
    }
}
