package tests.bag;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageBag {

    public int getCountProductInBag(){
        return $$(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=submitpayment\"]/table/tbody//tr")).size()-1;
    }

    public void clearBag() {
        $(byXpath("//input[@type=\"reset\"]")).click();
    }

    public void checkTitle(String title) {
        $((byXpath("(//font[@face=\"Arial\"])[2]/h3"))).shouldHave(text(title));
    }

}
