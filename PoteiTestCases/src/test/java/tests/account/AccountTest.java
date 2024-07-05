package tests.account;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.auth.PageRegistrationAndLogin;

import static com.codeborne.selenide.Selenide.open;

public class AccountTest extends BaseTest {

    private PageAccount pageAccount;
    private PageRegistrationAndLogin pageRegistrationAndLogin;

    @BeforeMethod
    private void beforeMethod() {
        pageRegistrationAndLogin = open("/cgi-bin/badstore.cgi?action=loginregister", PageRegistrationAndLogin.class);
        pageRegistrationAndLogin.registration("user1","email@gmail.com","password1");
        pageAccount =open("/cgi-bin/badstore.cgi?action=myaccount", PageAccount.class);

    }

    @Test
    public void testChangeFullNameInAccount_1() {
        pageAccount.checkChangeFullName("Neket",true);

    }

    @Test
    public void testChangeFullNameInAccount_2() {
        pageAccount.checkChangeFullName("",false);

    }

    @Test
    public void testChangeEmailNameInAccount_1() {
        pageAccount.checkChangeEmail("neket@gmail.com",true);
    }


    @Test
    public void testChangeEmailNameInAccount_2() {
        pageAccount.checkChangeEmail("",false);
    }

//    @Test
//    public void testChangePasswordInAccount() {
//        pageAccount.checkChangePassword("Password1");
//    }
}
