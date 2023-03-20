import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ShoppingCartPage {
    public HeaderBlock headerBlock;

    public ShoppingCartPage(HeaderBlock headerBlock) {
        this.headerBlock = headerBlock;
    }

    public ElementsCollection getCartItemList() {
        return $$(".cart_item");
    }

    public ShoppingCartPage removeAllItemsFromCart() {
        for (SelenideElement $$x : $$x("//button[starts-with(@id,'remove')]")) {
            $$x.click();
        }
        return this;
    }

    public CheckoutInformationPage clickToCheckoutBtn() {
        $("#checkout").click();
        return new CheckoutInformationPage(headerBlock);
    }
}
