package nextstep.subway.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class LineSteps {
    public static final String DEFAULT_NAME = "1호선";
    public static final String DEFAULT_COLOR = "bg-blue-600";

    public static ExtractableResponse<Response> 지하철노선_생성() {
        return 지하철노선_생성(DEFAULT_NAME, DEFAULT_COLOR);
    }

    public static ExtractableResponse<Response> 지하철노선_생성(String name, String color) {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("color", color);

        return RestAssured
                .given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/lines")
                .then().log().all().extract();
    }
}
