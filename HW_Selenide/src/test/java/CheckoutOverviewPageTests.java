import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPageTests extends BaseTest {

    @AfterEach
    void resetApp() {
        $("#react-burger-menu-btn").click();
        $("#reset_sidebar_link").click();
    }

    @Test
    void checkFinishCheckoutPossibility() {
        /*
         * Проверка что есть возможность нажать на кнопку FINISH
         * Проверить что после нажатия на кнопку заголовок на странице CheckoutCompletePage = THANK YOU FOR YOUR ORDER
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD)
                .addAllItemOnPageToBasket()
                .headerBlock.clickToCart()
                .clickToCheckoutBtn()
                .sendValidFilledInformationalForm(customerName, customerLastName, customerPostalCode)
                .clickToFinishBtn()
                .getCheckoutCompileHeader()
                .shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }
}
