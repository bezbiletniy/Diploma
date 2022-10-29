package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CardPage;
import static com.codeborne.selenide.Selenide.open;

public class CardTestEmptyFields {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldFillFormWithEmptyCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.emptyCardField();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.emptyMonthField();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.emptyYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.emptyOwnerField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.emptyCvcField();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.emptyFields();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.emptyCardField();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.emptyMonthField();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.emptyYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.emptyOwnerField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.emptyCvcField();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.emptyFields();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
        CardPage.monthError();
        CardPage.yearError();
        CardPage.ownerError();
        CardPage.cvcError();
    }

}
