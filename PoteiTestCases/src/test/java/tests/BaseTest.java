package tests;

import com.codeborne.selenide.Configuration;
import lombok.Data;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;

@Data
public class BaseTest {

    protected String url="http://192.168.31.246";

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl =url;
        Configuration.browser ="chrome";
    }

}
