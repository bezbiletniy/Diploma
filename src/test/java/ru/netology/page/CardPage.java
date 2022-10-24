package ru.netology.page;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$x;

public class CardPage {

    private SelenideElement payButton = $x("//span[text()=\"Купить\"]");
    private SelenideElement payInCreditButton = $x("//span[text()=\"Купить в кредит\"]");
    private SelenideElement numberOfCard = $x("//span[text()=\"Номер карты\"]");
    private SelenideElement month = $x("//span[text()=\"Месяц\"]");
    private SelenideElement year = $x("//span[text()=\"Год\"]");
    private SelenideElement owner = $x("//span[text()=\"Владелец\"]");
    private SelenideElement cvc = $x("//span[text()=\"CVC/CVV\"]");
    private SelenideElement continueButton = $x("//*[text()=\"Продолжить\"]");
    private SelenideElement sucNote = $x("//*[text()=\"Успешно\"]");
    private SelenideElement errNote = $x("//*[text()=\"Ошибка\"]");

    public void fullField(DataHelper.cardInfo info) {
        numberOfCard.setValue(info.get)
    }


    }



