import core.BaseTest;
import core.constants.PayConstants;
import dataProvider.CardDataProvider;
import dataProvider.UserDataProvider;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class PayTest extends BaseTest {

    @BeforeTest
    private void beforeTest(){
        openSiteBeforeMethod();
    }

    @Test(description = "successful purchase")
    public void testPayValidData() {
        //Arrange
        mainPage.clickWhatsNewButton();
        whatsNewPage.addProductToBag(1);
        mainPage.clickViewCartButton();
        bagPage.clickPlaceOrderButton();

        if(payPage.checkExistEmailField())
            payPage.setValueInEmailField(PayConstants.DEF_USER_EMAIL);

        payPage.setValueInNumberCardField(PayConstants.DEF_NUMBER_CARD);
        payPage.setValueInDateCardField(PayConstants.DEF_DATE_PAYMENT);

        //Act
        payPage.clickPlaceOrderButton();

        //Assert
        Alert alert = getWebDriver().switchTo().alert();
        assertEquals(PayConstants.ALERT_MESSAGE,alert.getText());
    }

    @Test(description = "purchase by invalid email for unregistered user", dataProvider = "invalidEmailProvider",dataProviderClass = UserDataProvider.class)
    public void testPayInvalidEmail(String email) {
        //Arrange
        mainPage.clickWhatsNewButton();
        whatsNewPage.addProductToBag(1);
        mainPage.clickViewCartButton();
        bagPage.clickPlaceOrderButton();

        if(payPage.checkExistEmailField())
            payPage.setValueInEmailField(email);

        payPage.setValueInNumberCardField(PayConstants.DEF_NUMBER_CARD);
        payPage.setValueInDateCardField(PayConstants.DEF_DATE_PAYMENT);

        //Act
        payPage.clickPlaceOrderButton();
        //Assert
        Alert alert = getWebDriver().switchTo().alert();
        assertNotEquals("Thank you for using MasterCard!",alert.getText());
    }

    @Test(dataProvider = "invalidNumberCardProvider",dataProviderClass = CardDataProvider.class)
    public void testPayInvalidCardNumber(Long numberCard) {
        //Arrange
        mainPage.clickWhatsNewButton();
        whatsNewPage.addProductToBag(1);
        mainPage.clickViewCartButton();
        bagPage.clickPlaceOrderButton();

        if(payPage.checkExistEmailField())
            payPage.setValueInEmailField(PayConstants.DEF_USER_EMAIL);

        payPage.setValueInNumberCardField(numberCard);
        payPage.setValueInDateCardField(PayConstants.DEF_DATE_PAYMENT);

        //Act
        payPage.clickPlaceOrderButton();
        //Assert
        Alert alert = getWebDriver().switchTo().alert();
        assertEquals(PayConstants.ALERT_MESSAGE,alert.getText());
    }

    @Test(dataProvider = "invalidDateCardProvider",dataProviderClass = CardDataProvider.class)
    public void testPayInvalidCardDate(String date) {
        //Arrange
        mainPage.clickWhatsNewButton();
        whatsNewPage.addProductToBag(1);
        mainPage.clickViewCartButton();
        bagPage.clickPlaceOrderButton();

        if(payPage.checkExistEmailField())
            payPage.setValueInEmailField(PayConstants.DEF_USER_EMAIL);

        payPage.setValueInNumberCardField(PayConstants.DEF_NUMBER_CARD);
        payPage.setValueInDateCardField(date);

        //Act
        payPage.clickPlaceOrderButton();
        //Assert
        Alert alert = getWebDriver().switchTo().alert();
        assertNotEquals(PayConstants.ALERT_MESSAGE,alert.getText());
    }

}
