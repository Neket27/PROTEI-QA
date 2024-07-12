import core.BaseTest;
import core.constants.GuestbookConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GuestbookTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        mainPage.clickSignOurGuestbookButton();
    }

    @DataProvider
    private Object[][] invalidEmailList() {
        return GuestbookConstants.INVALID_EMAIL_LIST;
    }

    @DataProvider
    private Object[][] invalidFullNameList() {
        return GuestbookConstants.INVALID_FUll_NAME_LIST;
    }

    @Test(description = "success add feedback")
    public void addFeedbackValidData(){
        //Arrange
        signOurGuestbookPage.setValueInNameField(GuestbookConstants.DEF_USER_FULL_NAME);
        signOurGuestbookPage.setValueInEmailField(GuestbookConstants.DEF_USER_EMAIL);
        signOurGuestbookPage.setValueInCommentsField(GuestbookConstants.DEF_USER_MESSAGE);
        //Act
        signOurGuestbookPage.clickAddEntryButton();
        //Assert
        signOurGuestbookPage.checkOnFeedbackBlockContains(GuestbookConstants.DEF_USER_FULL_NAME,GuestbookConstants.DEF_USER_EMAIL,GuestbookConstants.DEF_USER_MESSAGE);
    }

    @Test(description = "add feedback with invalid full name", dataProvider = "invalidFullNameList")
    public void addFeedbackInvalidFullName(String fullName){
        //Arrange
        signOurGuestbookPage.setValueInNameField(fullName);
        signOurGuestbookPage.setValueInEmailField(GuestbookConstants.DEF_USER_EMAIL);
        signOurGuestbookPage.setValueInCommentsField(GuestbookConstants.DEF_USER_MESSAGE);
        //Act
        signOurGuestbookPage.clickAddEntryButton();
        //Assert
        signOurGuestbookPage.checkOnFeedbackBlockNotContains(GuestbookConstants.DEF_USER_FULL_NAME,GuestbookConstants.DEF_USER_EMAIL,GuestbookConstants.DEF_USER_MESSAGE);
    }

    @Test(description = "add feedback with invalid email", dataProvider = "invalidEmailList")
    public void addFeedbackInvalidEmail(String email){
        //Arrange
        signOurGuestbookPage.setValueInNameField(GuestbookConstants.DEF_USER_FULL_NAME);
        signOurGuestbookPage.setValueInEmailField(email);
        signOurGuestbookPage.setValueInCommentsField(GuestbookConstants.DEF_USER_MESSAGE);
        //Act
        signOurGuestbookPage.clickAddEntryButton();
        //Assert
        signOurGuestbookPage.checkOnFeedbackBlockNotContains(GuestbookConstants.DEF_USER_FULL_NAME,GuestbookConstants.DEF_USER_EMAIL,GuestbookConstants.DEF_USER_MESSAGE);
    }

}
