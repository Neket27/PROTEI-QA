package core.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement homeButton = $("//");
    public SelenideElement whatsNewButton = $("//");
    public SelenideElement loginButton = $(byXpath("//*[contains(text(),'Login / Register')]"));
    public SelenideElement headerAfterAuth = $(byXpath("//*[contains(text(),'Big Spender')]"));
    public SelenideElement headerIframe = $(byXpath("//*[@id=\"hdcart\"]/iframe"));

    //...etc
}
