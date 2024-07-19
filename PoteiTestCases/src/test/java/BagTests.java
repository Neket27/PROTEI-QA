import core.BaseTest;
import core.properties.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.AssertJUnit.assertEquals;

public class BagTests extends BaseTest {

    @BeforeTest
    private void beforeTest(){
        openSiteBeforeMethod();
    }


    @Test
    void testAddProductInBag(){
        //Arrange
        mainPage.clickWhatsNewButton();
        whatsNewPage.choiceProductInTable(1);
        whatsNewPage.clickAddItemsToCardButton();
        //Act
        mainPage.clickViewCartButton();
        //Assert
        assertEquals(1,bagPage.getCountProductInBag());
    }

    @Test
    void clearBag(){
        //Arrange
        mainPage.clickViewCartButton();
        //Act
        bagPage.clickResetBagButton();
        //Assert
        assertEquals(0,bagPage.getCountProductInBag());
    }

    @Test
    public void testAddProductInBagWhenItemsExistInBag(){
        //Arrange
        mainPage.clickWhatsNewButton();
        whatsNewPage.choiceProductInTable(1);
        whatsNewPage.clickAddItemsToCardButton();

        mainPage.clickWhatsNewButton();
        whatsNewPage.choiceProductInTable(2);
        whatsNewPage.choiceProductInTable(3);
        whatsNewPage.clickAddItemsToCardButton();
        //Act
        mainPage.clickViewCartButton();
        //Assert
        assertEquals(3,bagPage.getCountProductInBag());
    }

    @Test
    public void testRedirectionOnPageBagAfterAddProductInBag(){
        //Arrange
        mainPage.clickWhatsNewButton();
        //Act
        whatsNewPage.addProductToBag(1);
        //Assert
        assertEquals(Properties.url +"/cgi-bin/badstore.cgi?action=cartview",url());
    }

    @Test
    void testViewProductAndCostInBag(){
        //Arrange
        mainPage.clickWhatsNewButton();
        whatsNewPage.choiceProductInTable(1);
        whatsNewPage.clickAddItemsToCardButton();
        //Act
        mainPage.clickViewCartButton();
        //Assert
        bagPage.checkTitle("Cart Contains: 1 items at $11.50");
    }

}
