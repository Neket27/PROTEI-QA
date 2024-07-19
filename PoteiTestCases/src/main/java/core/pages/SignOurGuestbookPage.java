package core.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Data
public class SignOurGuestbookPage {

   private final SelenideElement nameField = $(byXpath("//input[@name=\"name\"]"));
   private final SelenideElement emailField = $(byXpath("//input[@name=\"email\"]"));
   private final SelenideElement commentsField = $(byXpath("//textarea[@name=\"comments\"]"));
   private final SelenideElement addEntryButton = $(byXpath("//input[@type=\"submit\"]"));
   private final SelenideElement feedbackBlock = $(byXpath("(//font)[3]"));

   public SignOurGuestbookPage setValueInNameField(String name){
      nameField.val(name);
      return this;
   }
   public SignOurGuestbookPage setValueInEmailField(String email){
      emailField.val(email);
      return this;
   }
   public SignOurGuestbookPage setValueInCommentsField(String comments){
      commentsField.val(comments);
      return this;
   }

   public SignOurGuestbookPage clickAddEntryButton(){
      addEntryButton.click();
      return this;
   }

   public SignOurGuestbookPage addFeedback(String fullName, String email, String message){
      nameField.val(fullName);
      emailField.val(email);
      commentsField.val(message);
      addEntryButton.click();
      return this;
   }

   public SignOurGuestbookPage checkOnFeedbackBlockContains(String fullName, String email, String message){
      feedbackBlock.shouldHave(text(fullName));
      feedbackBlock.shouldHave(text(email));
      feedbackBlock.shouldHave(text(message));
      return this;
   }

   public SignOurGuestbookPage checkOnFeedbackBlockNotContains(String fullName, String email, String message){
      feedbackBlock.shouldNotHave(text(fullName));
      feedbackBlock.shouldNotHave(text(email));
      feedbackBlock.shouldNotHave(text(message));
      return this;
   }
}
