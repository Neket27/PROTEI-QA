package core.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class ViewPreviousOrdersPages {
    private final ElementsCollection tableOrders =  $$(byXpath("(//font[@face=\"Arial\"])[2]//tr"));

    public int getCountProduct(){
        return tableOrders.size()-1;
    }
}
