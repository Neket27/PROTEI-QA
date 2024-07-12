package authTest.verificationAuthorization.impl;

import authTest.verificationAuthorization.VerificationAuthorization;
import com.codeborne.selenide.Selenide;
import core.BaseTest;
import org.testng.Assert;

public class VerificationAuthorizationImpl extends BaseTest implements VerificationAuthorization {

    @Override
    public void checkAuthorization(boolean success) {
        Selenide.switchTo().frame(mainPage.getHeaderIframe());
        if(success)
            Assert.assertTrue(mainPage.getHeaderAfterAuth().exists());
        else
            Assert.assertFalse(mainPage.getHeaderAfterAuth().exists());
        Selenide.switchTo().defaultContent();
    }
}
