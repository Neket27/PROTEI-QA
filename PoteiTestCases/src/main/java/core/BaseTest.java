package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.pages.*;
import core.properties.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected MainPage mainPage = new MainPage();
    protected AuthPage authPage = new AuthPage();
    protected WhatsNewPage whatsNewPage = new WhatsNewPage();
    protected BagPage bagPage = new BagPage();
    protected MyAccountPage myAccountPage = new MyAccountPage();
    protected SignOurGuestbookPage signOurGuestbookPage = new SignOurGuestbookPage();
    protected PayPage payPage = new PayPage();
    protected ViewPreviousOrdersPages viewPreviousOrdersPages = new ViewPreviousOrdersPages();

    @BeforeTest
    protected void openSiteBeforeTest() {
        setup();
    }

    @BeforeMethod
    protected void openSiteBeforeMethod() {
        setup();
    }

    private void setup(){
        Configuration.browser = Properties.browser;
        Selenide.open(Properties.url);
    }
}
