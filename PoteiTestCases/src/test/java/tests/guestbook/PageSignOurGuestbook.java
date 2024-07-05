package tests.guestbook;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PageSignOurGuestbook {

    public void addFeedback(String fullName, String email, String message){
        $(byXpath("//input[@name=\"name\"]")).val(fullName);
        $(byXpath("//input[@name=\"email\"]")).val(email);
        $(byXpath("//textarea[@name=\"comments\"]")).val(message);
        $(byXpath("//input[@type=\"submit\"]")).click();
    }
}
