package core.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Data
public class WhatsNewPage {

    private final SelenideElement checkboxListChoiceProduct =  $(byXpath("(//td[input[@name='cartitem']])"));
    private final SelenideElement addItemsToCardButton = $(byXpath("//input[@name=\"Add Items to Cart\"]"));
    private final SelenideElement resetChoiceCheckboxButton = $(byXpath("//input[@name=\"Add Items to Cart\"]"));

    public void choiceProductInTable(int  numberProductInTable) {
        $(byXpath("(//td[input[@name='cartitem']])["+numberProductInTable+"]")).click();
    }

    public void clickAddItemsToCardButton() {
        $(byXpath("//input[@name=\"Add Items to Cart\"]")).click();
    }

    public void clickResetButton() {
        $(byXpath("//input[@name=\"reset\"]")).click();
    }

    public void addProductToBag(int numberProductInTable){
        choiceProductInTable(numberProductInTable);
        clickAddItemsToCardButton();
    }
}
