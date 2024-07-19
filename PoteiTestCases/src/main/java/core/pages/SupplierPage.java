package core.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Data
public class SupplierPage {

    private final SelenideElement emailAddressField = $(byXpath("//input[@name=\"email\"]"));
    private final SelenideElement passwordField = $(byXpath("//input[@name=\"passwd\"]"));
    private final SelenideElement loginField = $(byXpath("//input[@name=\"Login\"]"));
}
