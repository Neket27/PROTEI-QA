import core.BaseTest;
import core.constants.AccountConstants;
import core.constants.AuthConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @BeforeMethod
    private void beforeMethod() {
        mainPage.clickLoginAndRegisterButton();
        authPage.registration(AuthConstants.DEF_USER_FULL_NAME, AuthConstants.DEF_USER_EMAIL, AuthConstants.DEF_USER_PASSWORD);
        mainPage.clickMyAccountButton();
    }

    @DataProvider
    public Object[][] invalidFullNameList() {
        return AccountConstants.INVALID_FUll_NAME_LIST;
    }

    @DataProvider
    public Object[][] invalidEmailList() {
        return AccountConstants.INVALID_EMAIL_LIST;
    }


    @Test(description = "Change full name user with valid value")
    public void checkChangeFullName(){
        //Arrange
        setValidDataUser();
        //Act
        changeDataUser();
        //Assert
        myAccountPage.checkTitleContainsFullName(AccountConstants.DEF_USER_NEW_FULL_NAME);
    }

    @Test(description = "Change email user with valid value")
    public void checkChangeEmail(){
        //Arrange
        setValidDataUser();
        //Act
        changeDataUser();
        //Assert
        myAccountPage.checkTitleContainsEmail(AccountConstants.DEF_USER_NEW_EMAIL);
    }

    @Test(description = "Change data user with invalid full name",dataProvider = "invalidFullNameList")
    public void checkChangeFullNameOnInvalidValue(String fullName){
        //Arrange
        myAccountPage.setValueInFullNameField(fullName);
        myAccountPage.setValueInEmailField(AccountConstants.DEF_USER_EMAIL);
        myAccountPage.setValueInNewPasswordField(AccountConstants.DEF_USER_PASSWORD);
        myAccountPage.setValueInVerifyNewPasswordField(AccountConstants.DEF_USER_PASSWORD);
        //Act
        changeDataUser();
        //Assert
        myAccountPage.checkTitleNotContainsEmail(AccountConstants.DEF_USER_FULL_NAME);
    }

    @Test(description = "Change data user with valid data", dataProvider = "invalidEmailList")
    public void checkChangeEmailOnInvalidValue(String email){
        //Arrange
        myAccountPage.setValueInFullNameField(AccountConstants.DEF_USER_FULL_NAME);
        myAccountPage.setValueInEmailField(email);
        myAccountPage.setValueInNewPasswordField(AccountConstants.DEF_USER_PASSWORD);
        myAccountPage.setValueInVerifyNewPasswordField(AccountConstants.DEF_USER_PASSWORD);
        //Act
        changeDataUser();
        //Assert
        myAccountPage.checkTitleNotContainsFullName(AccountConstants.DEF_USER_EMAIL);
    }

    private void setValidDataUser(){
        myAccountPage.setValueInFullNameField(AccountConstants.DEF_USER_NEW_FULL_NAME);
        myAccountPage.setValueInEmailField(AccountConstants.DEF_USER_EMAIL);
        myAccountPage.setValueInNewPasswordField(AuthConstants.DEF_USER_PASSWORD);
        myAccountPage.setValueInVerifyNewPasswordField(AccountConstants.DEF_USER_PASSWORD);
    }

    private void changeDataUser(){
        myAccountPage.clickChangeDataAccountButton();
        mainPage.clickMyAccountButton();
    }
}
