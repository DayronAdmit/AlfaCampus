import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPageTests extends BaseTest {

    @AfterEach
    void resetApp() {
        $("#react-burger-menu-btn").click();
        $("#reset_sidebar_link").click();
    }

    @Test
    void checkGoodsAddedIsPresentInCart() {
        /*
         * Проверка что добавленные товары отображаются в корзине
         * Нужно добавить все товары в корзину и проверить что на странице корзины размер списка товаров = 6
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD)
                .addAllItemOnPageToBasket()
                .headerBlock.clickToCart()
                .getCartItemList()
                .shouldHave(size(6));
    }

    @Test
    void checkDeleteGoodsFromCartPossibility() {
        /*
         * Проверка что есть возможность удалить добавленные товары из корзины
         * Удалить добавленные товары (пререквизит к тесту - товары должны быть добавлены в корзину) и проверить что счетчик в блоке
         * HeaderBlock не отображается
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD)
                .addAllItemOnPageToBasket();
        authorizationPage.headerBlock.clickToCart()
                .removeAllItemsFromCart()
                .headerBlock.getBadgeCounterOfItemsInCart()
                .shouldNot(visible);
    }
}
