package tests.navigatePanel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigatePanel extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        open(url);

    }

    @Test
    public void testTransitionOnHome(){
        $("a[href=\"/cgi-bin/badstore.cgi\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi");
    }

    @Test
    public void testTransitionOnWhatNew(){
        $("a[href=\"/cgi-bin/badstore.cgi?action=whatsnew\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi?action=whatsnew");
    }

    @Test
    public void testTransitionOnSignOurGuestbook(){
        $("a[href=\"/cgi-bin/badstore.cgi?action=guestbook\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi?action=guestbook");
    }

    @Test
    public void testTransitionOnViewPreviousOrders(){
        $("a[href=\"/cgi-bin/badstore.cgi?action=viewprevious\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi?action=viewprevious");
    }

    @Test
    public void testTransitionOnAboutUs(){
        $("a[href=\"/cgi-bin/badstore.cgi?action=aboutus\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi?action=aboutus");
    }

    @Test
    public void testTransitionOnMyAccount(){
        $("a[href=\"/cgi-bin/badstore.cgi?action=myaccount\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi?action=myaccount");
    }

    @Test
    public void testTransitionOnLoginAndRegister(){
        $("a[href=\"/cgi-bin/badstore.cgi?action=loginregister\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi?action=loginregister");
    }

    @Test
    public void testTransitionOnSupplierLogin(){
        $("a[href=\"/cgi-bin/badstore.cgi?action=supplierlogin\"]").click();
        assertEquals(url(),url+"/cgi-bin/badstore.cgi?action=supplierlogin");
    }

    @Test
    public void testSupplierContractFileDownload() {
        $("a[href=\"/cgi-bin/badstore.cgi?action=supplierlogin\"]").click();
        File downloadedFile = new File("/home/neket/Загрузки/contract (1).doc");
        assertTrue(downloadedFile.isFile());
    }

    @Test
    public void testTransitionOnSupplierProcedures() {
        $("a[href=\"/cgi-bin/badstore.cgi\"]").click();
        $("a[href=\"/Procedures/UploadProc.html\"]").click();
        assertEquals(url(),url+"/Procedures/UploadProc.html");
    }

}
