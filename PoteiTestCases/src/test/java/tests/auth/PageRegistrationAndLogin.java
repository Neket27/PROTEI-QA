package tests.auth;

import org.openqa.selenium.Cookie;

import java.util.Set;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.fail;

public class PageRegistrationAndLogin {

    public void registration(String fullName, String email, String password) {
        checkRegistration(fullName,email,password);
    }

    public boolean checkRegistration(String fullName, String email, String password) {
        $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"fullname\"]")).val(fullName);
        $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"email\"]")).val(email);
        $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@name=\"passwd\"]")).val(password);
        $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=register\"]//input[@type=\"submit\"]")).click();

        Set<Cookie> cookies = getWebDriver().manage().getCookies();
        if (cookies.stream().filter(e -> e.getName().equals("SSOid")).collect(Collectors.toSet()).isEmpty()) {
//            fail();
            return false;
        }

        return true;

    }


    public boolean checkLoginValidData(String fullName, String email, String password) {
        $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=login\"]//input[@name=\"email\"]")).val(email);
        $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=login\"]//input[@name=\"passwd\"]")).val(password);
        $(byXpath("//form[@action=\"/cgi-bin/badstore.cgi?action=login\"]//input[@type=\"submit\"]")).click();
//        $(byXpath("//*[@face='Arial Narrow']/b")).shouldHave(text(fullName));

        Set<Cookie> cookies = getWebDriver().manage().getCookies();
        if (cookies.stream().filter(e -> e.getName().equals("SSOid")).collect(Collectors.toSet()).isEmpty()) {
//            fail();
            return false;
        }

        return true;


    }
}

