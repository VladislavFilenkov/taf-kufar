package by.itacademy.filenkovvladislav.taf.kufar;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class KufarTestAPI {
    @Test
    public void testLogin() {
        String body = "{\"password\":\"d23f23d23d\"," +
                "\"login\":\"test2342@test.com\"}";

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("token_type", "user");
        given().when().header("Content-Type", "application/json")
                .queryParams(queryParams).body(body)
                .post("https://www.kufar.by/l/api/login/v2/auth/signin").then().log().body();
    }
    @Test
    public void testSearch() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("query", "adidas");
        queryParams.put("rgn", "all");
        queryParams.put("utm_queryOrigin", "Manually_typed");
        given().when().queryParams(queryParams).get("https://www.kufar.by/l").then().log().body();
    }
}
