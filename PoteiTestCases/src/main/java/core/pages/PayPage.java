package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.BaseTest;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PayPage {

    private final SelenideElement emailField = $(byXpath("//input[@name=\"email\"]"));
    private final SelenideElement numberCardField = $(byXpath("//input[@name=\"ccard\"]"));
    private final SelenideElement dateCardField = $(byXpath("//input[@name=\"expdate\"]"));
    private final SelenideElement placeOrderButton = $(byXpath("//input[@name=\"subccard\"]"));

    public void pay(String email, Long numberCard, String date){
        emailField.val(email);
        numberCardField.val(numberCard.toString());
        dateCardField.val(date);
        placeOrderButton.click();
    }

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }

    public boolean checkExistEmailField(){
        return emailField.exists();
    }

    public void setValueInEmailField(String email){
        emailField.setValue(email);
    }

    public void setValueInNumberCardField(Long numberCard){
        numberCardField.setValue(numberCard.toString());
    }

    public void setValueInDateCardField(String date){
        dateCardField.setValue(date);
    }
}
