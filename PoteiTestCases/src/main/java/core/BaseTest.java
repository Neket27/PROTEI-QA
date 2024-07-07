package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.pages.AuthPage;
import core.pages.MainPage;
import core.properties.Properties;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public MainPage mainPage = new MainPage();
    public AuthPage authPage = new AuthPage();

    @BeforeMethod
    protected void openSite() {
        Configuration.browser = Properties.browser;
        Selenide.open(Properties.url);
    }
}
