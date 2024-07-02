package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PageRegistrationAndLogin {

       public void checkRegistration(String fullName, String email, String password) {
           $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"fullname\"]")).val(fullName);
           $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"email\"]")).val(email);
           $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"passwd\"]")).val(password);
           $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@type=\"submit\"]")).click();
       }

}

