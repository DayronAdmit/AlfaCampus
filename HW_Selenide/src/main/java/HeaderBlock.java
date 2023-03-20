import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderBlock {

    public SelenideElement getBadgeCounterOfItemsInCart() {
        return $x("//span[@class='shopping_cart_badge']");
    }

    public ShoppingCartPage clickToCart() {
        $("#shopping_cart_container").click();
        return new ShoppingCartPage(this);
    }

    public void clickToDropDownMenuIcon() {
        $("#react-burger-menu-btn").click();
    }

    public void clickToDropDownMenuCloseIcon() {
        $("#react-burger-cross-btn").click();
    }

    public AuthorizationPage clickToLogoutBtn() {
        clickToDropDownMenuIcon();
        $("#logout_sidebar_link").click();
        return new AuthorizationPage();
    }
}
