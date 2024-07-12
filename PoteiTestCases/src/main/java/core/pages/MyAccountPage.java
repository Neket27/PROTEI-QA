package core.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Data
public class MyAccountPage {

    private final SelenideElement fullNameField =  $(byXpath("//input[@name=\"fullname\"]"));
    private final SelenideElement emailField =  $(byXpath("//input[@name=\"newemail\"]"));
    private final SelenideElement newPasswordField =  $(byXpath("//input[@name=\"newpasswd\"]"));
    private final SelenideElement verifyNewPasswordField =  $(byXpath("//input[@name=\"vnewpasswd\"]"));
    private final SelenideElement changeDataAccountButton =  $(byName("DoMods"));
    private final SelenideElement titleFullName = $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=moduser\"]"));
    private final SelenideElement titleEmail =             $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=moduser\"]"));

    public void setValueInFullNameField(String fullName) {
        fullNameField.val(fullName);
    }

    public void setValueInEmailField(String email) {
        emailField.val(email);
    }

    public void setValueInNewPasswordField(String newPassword) {
        newPasswordField.val(newPassword);
    }

    public void setValueInVerifyNewPasswordField(String newPassword) {
        verifyNewPasswordField.val(newPassword);
    }

    public void clickChangeDataAccountButton() {
        changeDataAccountButton.click();
    }

    public void checkTitleContainsFullName(String fullName) {
        titleFullName.shouldHave(text("Current Full Name: "+fullName));
    }
    public void checkTitleNotContainsFullName(String fullName) {
        titleFullName.shouldNotHave(text("Current Full Name: "+fullName));
    }

    public void checkTitleContainsEmail(String email) {
        titleFullName.shouldHave(text("Current Email Address: "+email));
    }

    public void checkTitleNotContainsEmail(String email) {
        titleFullName.shouldNotHave(text("Current Email Address: "+email));
    }
}
