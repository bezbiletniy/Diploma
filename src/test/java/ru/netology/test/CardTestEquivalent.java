package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CardPage;
import static com.codeborne.selenide.Selenide.open;

public class CardTestEquivalent {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldFillFormWithApprovedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithRandomCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.randomField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithRandomFieldForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.randomField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndNextMonth();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndNextMonth();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndPastMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndPastMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndNextYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndNextYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndPastYear();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndPastYear();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndWrongCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndWrongCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndZeroMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndZeroMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithThirteenthMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndThirteenthMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithThirteenthMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndThirteenthMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndZeroCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndZeroCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.shortCard();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.shortCard();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndRussiaName();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndRussiaName();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithMoreThanFiveYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelper.approvedFieldAndMoreThanFiveYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithMoreThanFiveYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelper.approvedFieldAndMoreThanFiveYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }


}
