package tests.pay;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PagePay {

    public void pay(String email, String numberCard, String date){
        $(byXpath("//input[@name=\"email\"]")).val(email);
        $(byXpath("//input[@name=\"ccard\"]")).val(numberCard);
        $(byXpath("//input[@name=\"expdate\"]")).val(date);
        $(byXpath("//input[@name=\"subccard\"]")).click();
    }

}
