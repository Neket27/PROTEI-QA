package tests.bag;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PageWhatNew {

    public void addProductsInBag(int countProduct) {
            for (int i = 1; i <= countProduct; i++)
                $(byXpath("(//td[input[@name='cartitem']])["+i+"]")).click();
                $(byXpath("//input[@name=\"Add Items to Cart\"]")).click();
    }


}
