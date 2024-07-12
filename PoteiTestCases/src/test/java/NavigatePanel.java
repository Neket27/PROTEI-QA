import core.BaseTest;
import core.properties.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigatePanel extends BaseTest {

    @Test
    public void testTransitionOnHome(){
        mainPage.clickHomeButton();
        assertEquals(url(), Properties.url+"/cgi-bin/badstore.cgi");
    }

    @Test
    public void testTransitionOnWhatNew(){
        mainPage.clickWhatsNewButton();
        assertEquals(url(),Properties.url+"/cgi-bin/badstore.cgi?action=whatsnew");
    }

    @Test
    public void testTransitionOnSignOurGuestbook(){
        mainPage.clickSignOurGuestbookButton();
        assertEquals(url(),Properties.url+"/cgi-bin/badstore.cgi?action=guestbook");
    }

    @Test
    public void testTransitionOnViewPreviousOrders(){
        mainPage.clickViewPreviousOrdersButton();
        assertEquals(url(),Properties.url+"/cgi-bin/badstore.cgi?action=viewprevious");
    }

    @Test
    public void testTransitionOnAboutUs(){
       mainPage.clickAboutUsButton();
        assertEquals(url(),Properties.url+"/cgi-bin/badstore.cgi?action=aboutus");
    }

    @Test
    public void testTransitionOnMyAccount(){
        mainPage.clickMyAccountButton();
        assertEquals(url(),Properties.url+"/cgi-bin/badstore.cgi?action=myaccount");
    }

    @Test
    public void testTransitionOnLoginAndRegister(){
        mainPage.clickLoginAndRegisterButton();
        assertEquals(url(),Properties.url+"/cgi-bin/badstore.cgi?action=loginregister");
    }

    @Test
    public void testTransitionOnSupplierLogin(){
        mainPage.clickHomeButton();
        mainPage.clickSupplierLoginButton();
        assertEquals(url(),Properties.url+"/cgi-bin/badstore.cgi?action=supplierlogin");
    }

    @Test
    public void testSupplierContractFileDownload() {
        mainPage.clickSupplierContractButton();
        File downloadedFile = new File("/home/neket/Загрузки/contract (1).doc");
        assertTrue(downloadedFile.isFile());
    }

    @Test
    public void testTransitionOnSupplierProcedures() {
        mainPage.clickHomeButton();
        mainPage.getSupplierProceduresButton();
        assertEquals(url(),Properties.url+"/Procedures/UploadProc.html");
    }

}
