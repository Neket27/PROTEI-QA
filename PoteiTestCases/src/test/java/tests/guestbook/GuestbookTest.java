package tests.guestbook;

import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class GuestbookTest extends BaseTest {
    private PageSignOurGuestbook pageSignOurGuestbook;

    @Test
   public void addFeedbackValidData(){
        pageSignOurGuestbook = open("/cgi-bin/badstore.cgi?action=guestbook", PageSignOurGuestbook.class);
        pageSignOurGuestbook.addFeedback("Neket", "neket@gmail.com", "message");
        assertEquals(url+"/cgi-bin/badstore.cgi?action=doguestbook",url());
    }

    @Test
    public void addFeedbackInvalidEmail_1(){
        pageSignOurGuestbook = open("/cgi-bin/badstore.cgi?action=guestbook", PageSignOurGuestbook.class);
        pageSignOurGuestbook.addFeedback("Neket", "neket", "message");
        assertNotEquals(url+"/cgi-bin/badstore.cgi?action=doguestbook",url());
    }

    @Test
    public void addFeedbackInvalidEmail_2(){
        pageSignOurGuestbook = open("/cgi-bin/badstore.cgi?action=guestbook", PageSignOurGuestbook.class);
        pageSignOurGuestbook.addFeedback("Neket", "neket.ru", "message");
        assertNotEquals(url+"/cgi-bin/badstore.cgi?action=doguestbook",url());
    }

    @Test
    public void addFeedbackInvalidEmail_3(){
        pageSignOurGuestbook = open("/cgi-bin/badstore.cgi?action=guestbook", PageSignOurGuestbook.class);
        pageSignOurGuestbook.addFeedback("Neket", "neket@ko", "message");
        assertNotEquals(url+"/cgi-bin/badstore.cgi?action=doguestbook",url());
    }

}
