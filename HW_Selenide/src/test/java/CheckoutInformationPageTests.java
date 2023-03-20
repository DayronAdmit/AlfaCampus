import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPageTests extends BaseTest {
    static CheckoutInformationPage checkoutInformationPage;

    @BeforeEach
    void Add6ProductsToCart() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD)
                .addAllItemOnPageToBasket();
        checkoutInformationPage = authorizationPage.headerBlock.clickToCart().clickToCheckoutBtn();
    }

    @AfterEach
    void resetApp() {
        $("#react-burger-menu-btn").click();
        $("#reset_sidebar_link").click();
    }

    @Test
    void checkCheckoutPossibility() {
        /*
         * Проверка что есть возможность заполнить форму и продолжить оформление заказа
         * Нужно заполнить поля формы и выполнить нажатие на кнопку continue
         * Проверить что на странице CheckoutOverviewPage размер списка товаров = 6 (в пререквизите добавьте все 6 товаров)
         * */
        checkoutInformationPage.sendValidFilledInformationalForm(customerName, customerLastName, customerPostalCode);
        checkoutInformationPage.headerBlock.getBadgeCounterOfItemsInCart().shouldHave(text("6"));
    }

    @Test
    void checkErrorDueToBlankFirstNameInForm() {
        /*
         * Проверка что при пустом поле FirstName отдается соответствующая ошибка
         * */
        checkoutInformationPage.sendInvalidFilledInformationalForm("", customerLastName, customerPostalCode)
                .getErrorContainerOfFormFilled().shouldHave(text("Error: First Name is required"));
    }

    @Test
    void checkErrorDueToBlankLastNameInForm() {
        /*
         * Проверка что при пустом поле LastName отдается соответствующая ошибка
         * */
        checkoutInformationPage.sendInvalidFilledInformationalForm(customerName, "", customerPostalCode)
                .getErrorContainerOfFormFilled().shouldHave(text("Error: Last Name is required"));
    }

    @Test
    void checkErrorDueToBlankPostalCodeInForm() {
        /*
         * Проверка что при пустом поле PostalCode отдается соответствующая ошибка
         * */
        checkoutInformationPage.sendInvalidFilledInformationalForm(customerName, customerLastName, "")
                .getErrorContainerOfFormFilled().shouldHave(text("Error: Postal Code is required"));
    }
}
