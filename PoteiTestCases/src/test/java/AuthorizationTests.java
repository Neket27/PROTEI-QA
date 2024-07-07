import com.codeborne.selenide.Selenide;
import core.BaseTest;
import core.constants.AuthConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTests extends BaseTest {

    @Test(description = "Succesful authorization")
    public void authorization() {
        //Arrange
        mainPage.loginButton.click();
        authPage.emailField.setValue(AuthConstants.DEF_USER_EMAIL);
        authPage.passwordField.setValue(AuthConstants.DEF_USER_PASSWORD);
        //Act
        authPage.loginButton.click();
        //Assert
        Selenide.switchTo().frame(mainPage.headerIframe);
        Assert.assertTrue(mainPage.headerAfterAuth.exists());
        Selenide.switchTo().defaultContent();
    }

}
