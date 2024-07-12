import core.BaseTest;
import core.constants.AuthConstants;
import core.constants.PayConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class OrdersTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        mainPage.clickLoginAndRegisterButton();
        authPage.registration(AuthConstants.DEF_USER_FULL_NAME,AuthConstants.DEF_USER_EMAIL,AuthConstants.DEF_USER_PASSWORD);
    }

    @Test(description = "checking that the order is ordered")
    public void testOrder() {
        //Arrange
        mainPage.clickViewPreviousOrdersButton();
        int countOrders = viewPreviousOrdersPages.getCountProduct();

        mainPage.clickWhatsNewButton();
        whatsNewPage.addProductToBag(1);
        mainPage.clickViewCartButton();
        bagPage.clickPlaceOrderButton();
        payPage.pay(PayConstants.DEF_USER_EMAIL, PayConstants.DEF_NUMBER_CARD, PayConstants.DEF_DATE);
        //Act
        mainPage.clickViewPreviousOrdersButton();
        //Assert
        assertEquals(countOrders+1,viewPreviousOrdersPages.getCountProduct());
    }

}
