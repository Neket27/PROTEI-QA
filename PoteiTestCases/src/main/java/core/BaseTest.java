package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.pages.*;
import core.properties.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Pages{

    @BeforeMethod
    protected void openSiteBeforeMethod() {
        setup();
    }

    private void setup(){
        Configuration.browser = Properties.browser;
        Selenide.open(Properties.url);
    }
}
