package tests.inscriptions;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

   public void checkTitleWelcome(String fullName){
       SelenideElement iframeElement = $("iframe[name='bsheader']").shouldBe(visible, Duration.ofSeconds(10));
       switchTo().frame(iframeElement);

       SelenideElement pElement = $x("//p").shouldBe(visible, Duration.ofSeconds(10));
       pElement.shouldHave(text(fullName));
       switchTo().defaultContent();

//       $(byName("bsheader")).shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text(fullName));
    }
}
