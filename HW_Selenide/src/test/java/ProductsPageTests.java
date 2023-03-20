import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPageTests extends BaseTest {

    @AfterEach
    void resetApp() {
        $("#react-burger-menu-btn").click();
        $("#reset_sidebar_link").click();
    }

    @Test
    void checkAddToCartAllProductsPossibility() {
        /*
         * Проверка что добавленные товары отображаются в счетчике корзины
         * Нужно добавить все товары в корзину и проверить что счетчик корзины = 6
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD)
                .addAllItemOnPageToBasket()
                .headerBlock.getBadgeCounterOfItemsInCart().shouldHave(text("6"));
    }

    @Test
    void checkRemoveAllAddedProductsPossibility() {
        /*
         * Проверка что добавленные товары можно удалить на странице продуктов
         * Нужно удалить все товары на странице продуктов и проверить что счетчик корзины не отображается
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD)
                .addAllItemOnPageToBasket()
                .deleteAllItemFromBasket()
                .headerBlock.getBadgeCounterOfItemsInCart().shouldNot(visible);
    }
}
