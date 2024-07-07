package core.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    public SelenideElement emailField = $(byXpath("//input[@name=\"email\"]"));
    public SelenideElement passwordField = $(byXpath("//input[@name=\"passwd\"]"));
    public SelenideElement loginButton = $(byXpath("//input[@value=\"Login\"]"));

    //...etc
}
