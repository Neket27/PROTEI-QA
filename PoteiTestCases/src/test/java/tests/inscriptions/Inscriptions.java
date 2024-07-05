package tests.inscriptions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.auth.PageRegistrationAndLogin;

import static com.codeborne.selenide.Selenide.*;

public class Inscriptions extends BaseTest {
    PageRegistrationAndLogin pageRegistrationAndLogin;
    private HomePage homePage;

    @BeforeMethod
    private void beforeTest(){
        pageRegistrationAndLogin = open("/cgi-bin/badstore.cgi?action=loginregister", PageRegistrationAndLogin.class);
        pageRegistrationAndLogin.checkRegistration("user1","email@gmail.com","password1");
        homePage = open("/cgi-bin/badstore.cgi", HomePage.class);
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

    @Test
    private void testTitleWelcomeUser(){
        homePage.checkTitleWelcome("user1");
    }
}
