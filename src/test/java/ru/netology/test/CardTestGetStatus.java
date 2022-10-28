package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.page.CardPage;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.netology.data.SqlHelper.*;

public class CardTestGetStatus {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterAll
    static void tearDown () {
        cleanDatabase();
    }

    @Test
    public void shouldFillFormWithApprovedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();

        var expectedStatus = "APPROVED";
        var actualStatus = SqlHelper.getPaymentStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();

        var expectedStatus = "DECLINED";
        var actualStatus = SqlHelper.getPaymentStatus();
        assertEquals(expectedStatus, actualStatus);
    }
}







