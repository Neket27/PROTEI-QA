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

    public void registration(String fullName, String email, String password) {
       fullNameField.val(AuthConstants.DEF_USER_FULL_NAME);
       emailLoginField.val(AuthConstants.DEF_USER_EMAIL);
       passwordLoginField.val(AuthConstants.DEF_USER_PASSWORD);
       registrationButton.click();
    }

    public void setValueInFullNameField(String fullName) {
        fullNameField.val(fullName);
    }

    public void setValueInEmailRegistrationField(String email) {
        emailRegistrationField.val(email);
    }

    public void setValueInPasswordRegistrationField(String password) {
        passwordRegistrationField.val(password);
    }

    public void setValueInLoginField(String login) {
        emailLoginField.val(login);
    }

    public void setValueInPasswordLoginField(String password) {
        passwordLoginField.val(password);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
