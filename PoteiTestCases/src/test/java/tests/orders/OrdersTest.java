package tests.orders;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.bag.PageWhatNew;
import tests.pay.PagePay;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;

public class OrdersTest extends BaseTest {

    private PageOrders pageOrders;
    private PagePay pagePay;
    private PageWhatNew pageWhatNew;

    @Test
    public void testOrders() {
        clearBrowserCookies();
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);

        pagePay = open("/cgi-bin/badstore.cgi?action=submitpayment",PagePay.class);
        pagePay.pay("Neket","5536910016376277","22/34");

        pageOrders = open("/cgi-bin/badstore.cgi?action=viewprevious",PageOrders.class);
        assertEquals(1,pageOrders.getCountProduct());
    }

}
