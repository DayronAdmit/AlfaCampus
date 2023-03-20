import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HeaderBlockTests extends BaseTest {
    static ProductsPage productsPage;

    @BeforeEach
    void loginAsStandardUser() {
        productsPage = new AuthorizationPage()
                .authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD);
    }

    @Test
    void checkSuccessLogout() {
        productsPage.headerBlock.clickToLogoutBtn()
                .getUserNameFiled().should(empty);
    }

    @Test
    void checkSuccessDropDownMenuClose() {
        productsPage.headerBlock.clickToDropDownMenuIcon();
        productsPage.headerBlock.clickToDropDownMenuCloseIcon();
        $(".bm-menu-wrap").shouldBe(attribute("aria-hidden", "true"));
    }
}
