import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    public HeaderBlock headerBlock;

    public CheckoutCompletePage(HeaderBlock headerBlock) {
        this.headerBlock = headerBlock;
    }

    public SelenideElement getCheckoutCompileHeader() {
        return $(".complete-header");
    }
}
