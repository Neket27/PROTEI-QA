package tests.bag;

import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.AssertJUnit.assertEquals;

public class BagTest extends BaseTest {

    private PageWhatNew pageWhatNew;
    private PageBag pageBag;

    @Test
    void testAddProductInBag(){
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);
        pageBag =open("/cgi-bin/badstore.cgi?action=cartview", PageBag.class);
        assertEquals(1,pageBag.getCountProductInBag());
    }

    @Test
    void clearBag(){
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);
        pageBag =open("/cgi-bin/badstore.cgi?action=cartview", PageBag.class);
        pageBag.clearBag();
        assertEquals(0,pageBag.getCountProductInBag());
    }

    @Test
    public void testOpenPagePay(){
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        assertEquals(url+"/cgi-bin/badstore.cgi?action=whatsnew",url());
    }

    @Test
    public void testAddProductInBagWhenItemsExistInBag(){
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);
        pageBag =open("/cgi-bin/badstore.cgi?action=cartview", PageBag.class);

        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(2);
        pageBag =open("/cgi-bin/badstore.cgi?action=cartview", PageBag.class);

        assertEquals(3,pageBag.getCountProductInBag());
    }

    @Test
    public void testRedirectionOnPageBagAfterAddProductInBag(){
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);
        assertEquals(url+"/cgi-bin/badstore.cgi?action=cartview",url());
    }


    @Test
    void testViewProductAndCostInBag(){
        pageWhatNew =open("/cgi-bin/badstore.cgi?action=whatsnew",PageWhatNew.class);
        pageWhatNew.addProductsInBag(1);
        pageBag =open("/cgi-bin/badstore.cgi?action=cartview", PageBag.class);
        pageBag.checkTitle("Cart Contains: 1 items at $11.50");
    }

}
