package tests.orders;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageOrders {

    public int getCountProduct(){
        return $$(byXpath("(//font[@face=\"Arial\"])[2]//tr")).size()-1;
    }
}
