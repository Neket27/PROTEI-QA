package authTest;

import authTest.verificationAuthorization.VerificationAuthorization;
import authTest.verificationAuthorization.impl.VerificationAuthorizationImpl;
import core.BaseTest;
import core.constants.AuthConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private VerificationAuthorization verificationAuthorization;

    @BeforeTest
    private void beforeTest() {
        verificationAuthorization = new VerificationAuthorizationImpl();
    }

    @BeforeMethod
    private void beforeClass() {
        mainPage.getLoginAndRegisterButton().click();
    }

    @DataProvider
    public Object[][] invalidEmailList() {
        return AuthConstants.INVALID_EMAIL_LIST;
    }

    @DataProvider
    public Object[][] invalidPasswordList() {
        return AuthConstants.INVALID_PASSWORD_LIST;
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

    @Test(description = "Unsuccessful registration", dataProvider = "invalidEmailList")
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

    @Test(description = "Unsuccessful password",dataProvider = "invalidPasswordList")
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
