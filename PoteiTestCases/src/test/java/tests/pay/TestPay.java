package tests.pay;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.bag.PageWhatNew;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class TestPay extends BaseTest {

    private PagePay pagePay;
    private PageWhatNew pageWhatNew;

    @Test
    public void testPayValidData() {
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);

        pagePay = open("/cgi-bin/badstore.cgi?action=submitpayment",PagePay.class);
        pagePay.pay("Neket","5536910016376277","22/34");

        Alert alert = getWebDriver().switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Thank you for using MasterCard!",alertText);
    }

    @Test
    public void testPayInvalidEmail() {
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);

        pagePay = open("/cgi-bin/badstore.cgi?action=submitpayment",PagePay.class);
        pagePay.pay("","5536910016376277","34");

        Alert alert = getWebDriver().switchTo().alert();
        String alertText = alert.getText();
        assertNotEquals("Thank you for using MasterCard!",alertText);
    }

    @Test
    public void testPayInvalidCardNumber() {
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);

        pagePay = open("/cgi-bin/badstore.cgi?action=submitpayment",PagePay.class);
        pagePay.pay("Neket","553691","22/34");

        Alert alert = getWebDriver().switchTo().alert();
        String alertText = alert.getText();
        assertNotEquals("Thank you for using MasterCard!",alertText);
    }

    @Test
    public void testPayInvalidCardDate() {
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);

        pagePay = open("/cgi-bin/badstore.cgi?action=submitpayment",PagePay.class);
        pagePay.pay("Neket","5536910016376277","34");

        Alert alert = getWebDriver().switchTo().alert();
        String alertText = alert.getText();
        assertNotEquals("Thank you for using MasterCard!",alertText);
    }


}
