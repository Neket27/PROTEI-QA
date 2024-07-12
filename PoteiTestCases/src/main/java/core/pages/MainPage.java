package core.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Data
public class MainPage {

    private final SelenideElement homeButton = $(byXpath("//*[contains(text(),'Home')]"));
    private final SelenideElement whatsNewButton = $("a[href=\"/cgi-bin/badstore.cgi?action=whatsnew\"]");
    private final SelenideElement signOurGuestbookButton = $(byXpath("//*[contains(text(),'Sign Our Guestbook')]"));
    private final SelenideElement viewPreviousOrderButton = $(byXpath("//*[contains(text(),'View Previous Orders')]"));
    private final SelenideElement aboutUsButton = $(byXpath("//*[contains(text(),'About Us')]"));
    private final SelenideElement myAccountButton = $(byXpath("//*[contains(text(),'My Account')]"));
    private final SelenideElement loginAndRegisterButton = $(byXpath("//*[contains(text(),'Login / Register')]"));
    private final SelenideElement supplierLoginButton = $(byXpath("a[href=\"/cgi-bin/badstore.cgi?action=supplierlogin\"]"));
    private final SelenideElement supplierContractButton = $(byXpath("//*[contains(text(),'Supplier Contract')]"));
    private final SelenideElement supplierProceduresButton = $(byXpath("//*[contains(text(),'Supplier Procedures')]"));
    private final SelenideElement viewCartButton = $(byXpath("//*[contains(text(),'View Cart')]"));
    private final SelenideElement headerAfterAuth = $(byXpath("//*[contains(text(),'Nikita K')]"));
    private final SelenideElement headerIframe = $(byXpath("//*[@name=\"bsheader\"]"));

    public void clickHomeButton() {
        homeButton.click();
    }

    public void clickWhatsNewButton() {
        whatsNewButton.click();
    }

    public void clickSignOurGuestbookButton() {
        signOurGuestbookButton.click();
    }

    public void clickAboutUsButton() {
        aboutUsButton.click();
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

    public void clickLoginAndRegisterButton() {
        loginAndRegisterButton.click();
    }

    public void clickSupplierLoginButton() {
        supplierLoginButton.click();
    }

    public void clickSupplierContractButton() {
        supplierContractButton.click();
    }

    public void clickSupplierProceduresButton() {
        supplierProceduresButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public void clickHeaderAfterAuth() {
        headerAfterAuth.click();
    }

    public void clickHeaderIframe() {
        headerIframe.click();
    }

    public void clickViewPreviousOrdersButton(){
        viewPreviousOrderButton.click();
    }
}
