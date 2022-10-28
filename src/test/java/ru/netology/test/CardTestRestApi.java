package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CardTestRestApi {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    public void shouldBeRestForApprovedCard() {
        String request = "{\n" +
                "    \"number\": \"4444 4444 4444 4441\",\n" +
                "    \"month\": \"11\",\n" +
                "    \"year\": \"22\",\n" +
                "    \"holder\": \"Andrey Borodin\",\n" +
                "    \"cvc\": \"323\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(request).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(200).
                body("status", equalTo("APPROVED"));
    }

    @Test
    public void shouldBeRestForDeclinedCard() {
        String request = "{\n" +
                "    \"number\": \"4444 4444 4444 4442\",\n" +
                "    \"month\": \"11\",\n" +
                "    \"year\": \"22\",\n" +
                "    \"holder\": \"Andrey Borodin\",\n" +
                "    \"cvc\": \"323\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(request).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(200).
                body("status", equalTo("DECLINED"));
    }

    @Test
    public void shouldBeNotRestForRandomCard() {
        String request = "{\n" +
                "    \"number\": \"8776 5435 5365 2436\",\n" +
                "    \"month\": \"11\",\n" +
                "    \"year\": \"22\",\n" +
                "    \"holder\": \"Andrey Borodin\",\n" +
                "    \"cvc\": \"323\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(request).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(500).
                body("message", equalTo("400 Bad Request"));
    }
}
