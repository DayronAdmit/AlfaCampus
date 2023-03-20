import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {
    public HeaderBlock headerBlock;

    public ProductsPage(HeaderBlock headerBlock) {
        this.headerBlock = headerBlock;
    }

    public ElementsCollection getProductList() {
        return $$(".inventory_item");
    }

    public ProductsPage addAllItemOnPageToBasket() {
        for (SelenideElement $$x : $$x("//*[@class='inventory_item']//button")) {
            $$x.click();
        }
        return this;
    }

    public ProductsPage deleteAllItemFromBasket() {
        for (SelenideElement $$x : $$x("//button[starts-with(@id,'remove')]")) {
            $$x.click();
        }
        return this;
    }
}
