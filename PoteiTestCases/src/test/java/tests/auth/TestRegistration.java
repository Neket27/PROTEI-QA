package tests.auth;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.*;

public class TestRegistration extends BaseTest {
    private PageRegistrationAndLogin pageRegistrationAndLogin;

    @BeforeMethod
    private void beforeTest(){
        pageRegistrationAndLogin = open("/cgi-bin/badstore.cgi?action=loginregister", PageRegistrationAndLogin.class);
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

    @Test
    void testRegistrationValidData(){
        assertTrue(pageRegistrationAndLogin.checkRegistration("user1","email@gmail.com","password1"));
    }

    @Test
    void testRegistrationInvalidEmail_1(){
        assertFalse(pageRegistrationAndLogin.checkRegistration("user1","emailgmail.com","password1"));
    }

    @Test
    void testRegistrationInvalidEmail_2(){
        assertFalse(pageRegistrationAndLogin.checkRegistration("user1","emailgmail.com","password1"));
    }

    @Test
    void testRegistrationInvalidEmail_3(){
       assertFalse(pageRegistrationAndLogin.checkRegistration("user1","email","password1"));
    }

    @Test
    void testRegistrationInvalidEmail_4(){
       assertFalse(pageRegistrationAndLogin.checkRegistration("user1","/|?","password1"));
    }

    @Test
    void testRegistrationInvalidEmail_5(){
       assertFalse(pageRegistrationAndLogin.checkRegistration("user1","","password1"));
    }


    @Test
    void testRegistrationInvalidPassword_1(){
       assertFalse(pageRegistrationAndLogin.checkRegistration("user1","email@gmail.com","1234"));
    }

    @Test
    void testRegistrationInvalidPassword_2(){
       assertFalse( pageRegistrationAndLogin.checkRegistration("user1","email@gmail.com","1"));
    }

    @Test
    void testRegistrationInvalidPassword_3(){
      assertFalse(pageRegistrationAndLogin.checkRegistration("user1","email@gmail.com","xxxx1"));
    }

    @Test
    void testRegistrationInvalidPassword_4(){
    assertFalse(pageRegistrationAndLogin.checkRegistration("user1","email@gmail.com",".,/"));
    }

    @Test
    void testRegistrationInvalidPassword_5(){
      assertFalse(pageRegistrationAndLogin.checkRegistration("user1","email@gmail.com",""));
    }

}
