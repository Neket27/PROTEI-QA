package authTest;

import authTest.verificationAuthorization.VerificationAuthorization;
import authTest.verificationAuthorization.impl.VerificationAuthorizationImpl;
import core.BaseTest;
import core.constants.AuthConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthorizationTests extends BaseTest {

    private VerificationAuthorization verificationAuthorization;

    @BeforeTest
    private void beforeClass(){
        mainPage.clickLoginAndRegisterButton();
        authPage.registration(AuthConstants.DEF_USER_FULL_NAME, AuthConstants.DEF_USER_EMAIL, AuthConstants.DEF_USER_PASSWORD);
        verificationAuthorization = new VerificationAuthorizationImpl();
    }

    @BeforeMethod
    private void beforeMethod() {
        mainPage.clickLoginAndRegisterButton();
    }

    @DataProvider
    public Object[][] invalidEmailList() {
        return AuthConstants.INVALID_EMAIL_LIST;
    }

    @DataProvider
    public Object[][] invalidPasswordList() {
        return AuthConstants.INVALID_PASSWORD_LIST;
    }

    @Test(description = "Successful authorization")
    public void authorization() {
        //Arrange
        authPage.setValueInLoginField(AuthConstants.DEF_USER_EMAIL);
        authPage.setValueInPasswordLoginField(AuthConstants.DEF_USER_PASSWORD);
        //Act
        authPage.clickLoginButton();
        //Assert
        verificationAuthorization.checkAuthorization(true);
    }

    @Test(description = "Unsuccessful authorization", dataProvider = "invalidEmailList")
    public void authorizationInvalidEmail(String email) {
        //Arrange
        authPage.setValueInLoginField(email);
        authPage.setValueInPasswordRegistrationField(AuthConstants.DEF_USER_PASSWORD);
        //Act
        authPage.clickLoginButton();
        //Assert
        verificationAuthorization.checkAuthorization(false);
    }

    @Test(description = "Unsuccessful authorization", dataProvider = "invalidPasswordList")
    public void authorizationInvalidPassword(String password) {
        //Arrange
        authPage.setValueInLoginField(AuthConstants.DEF_USER_EMAIL);
        authPage.setValueInPasswordLoginField(password);
        //Act
        authPage.clickLoginButton();
        //Assert
        verificationAuthorization.checkAuthorization(false);
    }

}
