package tests.account;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageAccount {

    public void checkChangeFullName(String fullName,boolean successfully) {
        $(byXpath("//input[@name=\"fullname\"]")).val(fullName);
        $(byName("DoMods")).click();
        open("/cgi-bin/badstore.cgi?action=myaccount");
        if(successfully)
            $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=moduser\"]")).shouldBe(text("Current Full Name: "+fullName));
        else
            $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=moduser\"]")).shouldNotBe(text("Current Full Name: "+fullName));

    }

    public void checkChangeEmail(String email,boolean successfully) {
        $(byName("newemail")).val(email);
        $(byName("DoMods")).click();
        open("/cgi-bin/badstore.cgi?action=myaccount");
        if(successfully)
            $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=moduser\"]")).shouldBe(text("Current Email Address: "+email));
        else
            $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=moduser\"]")).shouldNotBe(text("Current Email Address: "+email));
    }

//    public void checkChangePassword(String password) {
//        $(byName("newpasswd")).val(password);
//        $(byName("vnewpasswd")).val(password);
//        $(byName("DoMods")).click();
//
//
//    }
}
