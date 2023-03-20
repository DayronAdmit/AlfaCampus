import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPage {
    public HeaderBlock headerBlock;

    public CheckoutInformationPage(HeaderBlock headerBlock) {
        this.headerBlock = headerBlock;
    }

    public CheckoutOverviewPage sendValidFilledInformationalForm(String name, String lastName, String postalCode) {
        $("input[data-test ='firstName']").setValue(name);
        $("input[data-test ='lastName']").setValue(lastName);
        $("input[data-test ='postalCode']").setValue(postalCode);
        $("input[data-test ='continue']").click();
        return new CheckoutOverviewPage(headerBlock);
    }

    public CheckoutInformationPage sendInvalidFilledInformationalForm(String name, String lastName, String postalCode) {
        $("input[data-test ='firstName']").setValue(name);
        $("input[data-test ='lastName']").setValue(lastName);
        $("input[data-test ='postalCode']").setValue(postalCode);
        $("input[data-test ='continue']").click();
        return this;
    }

    public SelenideElement getErrorContainerOfFormFilled() {
        return $("[data-test ='error']");
    }
}
