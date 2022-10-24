package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CardPage;

import static com.codeborne.selenide.Selenide.open;

public class CardTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void Test() {
        var loginPage = open("http://localhost:9999", CardPage.class);
        var payButtonClick = CardPage.payButton();
        var cardInfo = DataHelper.randomField();
        var fillPage = CardPage.fullField(cardInfo);


    }

}





