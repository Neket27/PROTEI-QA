package tests.auth;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.*;

public class TestLogin extends BaseTest {
    private PageRegistrationAndLogin pageRegistrationAndLogin;

    @BeforeMethod
    private void beforeTest(){
        pageRegistrationAndLogin = open("/cgi-bin/badstore.cgi?action=loginregister", PageRegistrationAndLogin.class);
        clearBrowserLocalStorage();
        clearBrowserCookies();
//        pageRegistrationAndLogin.checkRegistrationValidData("user1","email@gmail.com","password1");
    }

    @Test
    void testLoginValidData(){
        assertTrue(pageRegistrationAndLogin.checkLoginValidData("user1","email@gmail.com","password1"));
    }

    @Test
    void testLoginInvalidEmail_1(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","emailgmail.com","password1"));
    }

    @Test
    void testLoginInvalidEmail_2(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","emailgmail.com","password1"));
    }

    @Test
    void testLoginInvalidEmail_3(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","email","password1"));
    }

    @Test
    void testLoginInvalidEmail_4(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","/|?","password1"));
    }

    @Test
    void testLoginInvalidEmail_5(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","","password1"));
    }


    @Test
    void testLoginInvalidPassword_1(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","email@gmail.com","1234"));
    }

    @Test
    void testLoginInvalidPassword_2(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","email@gmail.com","1"));
    }

    @Test
    void testLoginInvalidPassword_3(){
       assertFalse( pageRegistrationAndLogin.checkLoginValidData("user1","email@gmail.com","xxxx1"));
    }

    @Test
    void testLoginInvalidPassword_4(){
        assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","email@gmail.com",".,/"));
    }

    @Test
    void testLoginInvalidPassword_5(){
       assertFalse(pageRegistrationAndLogin.checkLoginValidData("user1","email@gmail.com",""));
    }
}
