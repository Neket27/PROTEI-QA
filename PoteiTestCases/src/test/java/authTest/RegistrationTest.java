package authTest;

import authTest.verificationAuthorization.VerificationAuthorization;
import authTest.verificationAuthorization.impl.VerificationAuthorizationImpl;
import core.BaseTest;
import core.constants.AuthConstants;
import dataProvider.UserDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private VerificationAuthorization verificationAuthorization;

    @BeforeTest
    private void beforeTest() {
        openSiteBeforeMethod();
        verificationAuthorization = new VerificationAuthorizationImpl();
    }

    @BeforeMethod
    private void beforeClass() {
        mainPage.getLoginAndRegisterButton().click();
    }

    @Test(description = "Successful registration")
    public void registration() {
        //Arrange
        authPage.setValueInFullNameField(AuthConstants.DEF_USER_FULL_NAME);
        authPage.setValueInEmailRegistrationField(AuthConstants.DEF_USER_EMAIL);
        authPage.setValueInPasswordRegistrationField(AuthConstants.DEF_USER_PASSWORD);
        //Act
        authPage.clickRegistrationButton();
        //Assert
        verificationAuthorization.checkAuthorization(true);
    }

    @Test(description = "Unsuccessful registration", dataProvider = "invalidEmailProvider", dataProviderClass = UserDataProvider.class)
    public void registrationInvalidEmail(String email) {
        //Arrange
        authPage.setValueInFullNameField(AuthConstants.DEF_USER_FULL_NAME);
        authPage.setValueInEmailRegistrationField(email);
        authPage.setValueInPasswordRegistrationField(AuthConstants.DEF_USER_PASSWORD);
        //Act
        authPage.clickRegistrationButton();
        //Assert
        verificationAuthorization.checkAuthorization(false);
    }

    @Test(description = "Unsuccessful password",dataProvider = "invalidPasswordProvider", dataProviderClass = UserDataProvider.class)
    public void registrationInvalidPassword(String password) {
        //Arrange
        authPage.setValueInFullNameField(AuthConstants.DEF_USER_FULL_NAME);
        authPage.setValueInEmailRegistrationField(AuthConstants.DEF_USER_EMAIL);
        authPage.setValueInPasswordRegistrationField(password);
        //Act
        authPage.clickRegistrationButton();
        //Assert
        verificationAuthorization.checkAuthorization(false);
    }

}
