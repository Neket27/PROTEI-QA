package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl ="http://192.168.250.26";
        Configuration.browser ="chrome";
    }
}
