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

   public void setValueInNameField(String name){
      nameField.val(name);
   }
   public void setValueInEmailField(String email){
      emailField.val(email);
   }
   public void setValueInCommentsField(String comments){
      commentsField.val(comments);
   }

   public void clickAddEntryButton(){
      addEntryButton.click();
   }

   public void addFeedback(String fullName, String email, String message){
      nameField.val(fullName);
      emailField.val(email);
      commentsField.val(message);
      addEntryButton.click();
   }

   public void checkOnFeedbackBlockContains(String fullName, String email, String message){
      feedbackBlock.shouldHave(text(fullName));
      feedbackBlock.shouldHave(text(email));
      feedbackBlock.shouldHave(text(message));
   }

   public void checkOnFeedbackBlockNotContains(String fullName, String email, String message){
      feedbackBlock.shouldNotHave(text(fullName));
      feedbackBlock.shouldNotHave(text(email));
      feedbackBlock.shouldNotHave(text(message));
   }
}
