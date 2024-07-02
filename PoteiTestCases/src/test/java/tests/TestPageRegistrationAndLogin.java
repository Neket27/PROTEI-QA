package tests;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class TestPageRegistrationAndLogin extends BaseTest{

    @Test
    void testRegistration(){
        PageRegistrationAndLogin pageRegistrationAndLogin = open("/cgi-bin/badstore.cgi?action=loginregister", PageRegistrationAndLogin.class);
        pageRegistrationAndLogin.checkRegistration("user1","email1","password1");
    }

}
