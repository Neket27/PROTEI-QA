package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.constants.AuthConstants;
import lombok.Data;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Data
public class AuthPage {
    private final SelenideElement fullNameField = $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"fullname\"]"));
    private final SelenideElement emailRegistrationField = $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"email\"]"));
    private final SelenideElement passwordRegistrationField = $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"passwd\"]"));
    private final SelenideElement registrationButton = $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@type=\"submit\"]"));

    private final SelenideElement emailLoginField = $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=login\"]//input[@name=\"email\"]"));
    private final SelenideElement passwordLoginField= $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=login\"]//input[@name=\"passwd\"]"));
    private final SelenideElement loginButton =  $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=login\"]//input[@type=\"submit\"]"));

    public AuthPage setValueInFullNameField(String fullName) {
        fullNameField.val(fullName);
        return this;
    }

    public AuthPage setValueInEmailRegistrationField(String email) {
        emailRegistrationField.val(email);
        return this;
    }

    public AuthPage setValueInPasswordRegistrationField(String password) {
        passwordRegistrationField.val(password);
        return this;
    }

    public AuthPage setValueInLoginField(String login) {
        emailLoginField.val(login);
        return this;
    }

    public AuthPage setValueInPasswordLoginField(String password) {
        passwordLoginField.val(password);
        return this;
    }

    public AuthPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    public AuthPage clickLoginButton() {
        loginButton.click();
        return this;
    }

}
