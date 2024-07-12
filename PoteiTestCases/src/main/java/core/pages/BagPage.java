package core.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class BagPage {

    private final ElementsCollection tableBag = $$(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=submitpayment\"]/table/tbody//tr"));
    private final SelenideElement resetButton =$(byXpath("//input[@type=\"reset\"]"));
    private final SelenideElement placeOrderButton =$(byXpath("//input[@name=\"Place Order\"]"));
    private final SelenideElement title = $((byXpath("(//font[@face=\"Arial\"])[2]/h3")));
    private final SelenideElement placeOrder = $(byXpath("//input[@name=\"Place Order\"]"));

    public int getCountProductInBag(){
        return tableBag.size()-1;
    }

    public void clickResetBagButton() {
       resetButton.click();
    }

    public void checkTitle(String title) {
        this.title.shouldHave(text(title));
    }

    public void clickPlaceOrderButton() {
        placeOrder.click();
    }

}
