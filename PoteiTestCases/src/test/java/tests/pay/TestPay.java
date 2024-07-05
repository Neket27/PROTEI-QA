package tests.pay;

import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class TestPay extends BaseTest {

    private PagePay pagePay;

    @Test
    public void testPay() {
        pagePay = open("/cgi-bin/badstore.cgi?action=submitpayment",pagePay.getClass());
    }

}
