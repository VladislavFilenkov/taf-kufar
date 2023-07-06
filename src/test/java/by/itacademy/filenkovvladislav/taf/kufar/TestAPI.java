package by.itacademy.filenkovvladislav.taf.kufar;

import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestAPI {
    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        String body = "{\"password\":\"d23f23d23d\"," +
                "\"login\":\"test2342@test.com\"}";

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("token_type", "user");
        given().when().header("Content-Type", "application/json")
                .queryParams(queryParams).body(body)
                .post("https://www.kufar.by/l/api/login/v2/auth/signin").then().log().body();
    }
    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        String body = "{\"password\":\"\"," +
                "\"login\":\"\"}";

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("token_type", "user");
        given().when().header("Content-Type", "application/json")
                .queryParams(queryParams).body(body)
                .post("https://www.kufar.by/l/api/login/v2/auth/signin").then().log().body();
    }
    @Test
    public void testSearchAdidas() {
        String st1 = "оригинальные кроссовки adidas Superstar 2.0 W FX75";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("query", "adidas");
        queryParams.put("rgn", "all");
        queryParams.put("utm_queryOrigin", "Manually_typed");
        ValidatableResponse response = given().when().queryParams(queryParams).get("https://www.kufar.by/l").then();
        String actual = response.extract().asString();
        Document document = Jsoup.parse(actual);
        Elements head = document.getElementsByTag("h3");
        System.out.println(head.get(0).text());
    }
}
