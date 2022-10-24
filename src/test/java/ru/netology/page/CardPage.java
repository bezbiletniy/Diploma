package ru.netology.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import java.time.Duration;
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
        numberOfCard.setValue(info.CardNumberApproved());
        month.setValue(info.randomMonth());
        year.setValue(info.randomYear());
        owner.setValue(info.owner());
        cvc.setValue(info.CVC());
        continueButton.click();
    }

    public void payButton(){
        payButton.click();
    }
    public void payInCreditButton(){
        payInCreditButton.click();
    }

    public void payButtonApprovedCheck() {
        sucNote.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void payButtonDeclinedCheck() {
        errNote.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void payInCreditApprovedCheck() {
        sucNote.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void payInCreditDeclinedCheck() {
        errNote.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void cardNumberError() {
        numberOfCard.shouldHave(Condition.exactText("Неверный формат"));
    }
    public void monthError() {
        month.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }
    public void yearError() {
        year.shouldHave(Condition.exactText("Истёк срок действия карты"));
    }
    public void ownerError() {
        owner.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void cvcError() {
        cvc.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void emptyError() {
        numberOfCard.shouldHave(Condition.exactText("Неверный формат"));
    }

}



