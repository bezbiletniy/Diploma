package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardPage {

    private static SelenideElement payButton = $x("//*[.=\"Купить\"]");
    private static SelenideElement payInCreditButton = $x("//*[.=\"Купить в кредит\"]");
    private static SelenideElement numberOfCard = $x("//*[@placeholder='0000 0000 0000 0000']");
    private static SelenideElement month = $x("//*[@placeholder='08']");
    private static SelenideElement year = $x("//*[@placeholder='22']");
    private static ElementsCollection ownerSet = $$x("//*[@class='input__control']");
    private static SelenideElement owner = ownerSet.get(3);
    private static SelenideElement cvc = $x("//*[@placeholder='999']");
    private static ElementsCollection continueButtonSet = $$x("//*[@class='button__text']");
    private static SelenideElement continueButton = continueButtonSet.get(2);
    private static SelenideElement sucNote = $(byText("Операция одобрена Банком."));
    private static SelenideElement errNote = $(byText("Ошибка! Банк отказал в проведении операции."));

    private static SelenideElement emptyCardField = $(byText("Неверный формат"));

    private static SelenideElement emptyMonthField = $(byText("Неверный формат"));

    private static SelenideElement emptyYearField = $(byText("Неверный формат"));

    private static SelenideElement emptyOwnerField = $(byText("Поле обязательно для заполнения"));

    private static SelenideElement emptyCVCField = $(byText("Неверный формат"));


    public static void fullField(DataHelper.cardInfo info) {
        numberOfCard.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        owner.setValue(info.getOwner());
        cvc.setValue(info.getCvc());
        continueButton.click();
    }

    public static void payToButton() {
        payButton.click();
    }

    public static void payInCreditToButton() {
        payInCreditButton.click();
    }

    public static void successfulWay() {
        sucNote.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void unSuccessfulWay() {
        errNote.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void cardNumberError() {
        numberOfCard.shouldBe(Condition.visible);
    }

    public static void monthError() {
        month.shouldBe(Condition.visible);
    }

    public static void yearError() {
        year.shouldBe(Condition.visible);
    }

    public static void ownerError() {
        owner.shouldBe(Condition.visible);
    }

    public static void cvcError() {
        cvc.shouldBe(Condition.visible);
    }

}



