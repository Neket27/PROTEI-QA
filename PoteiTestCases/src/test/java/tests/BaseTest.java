package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl ="http://192.168.31.246";
        Configuration.browser ="chrome";
    }

}
