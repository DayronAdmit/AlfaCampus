import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class AuthorizationTests extends BaseTest {

    @Test
    void checkSuccessLogin() {
        /*
         * Проверка успешной авторизации
         * После авторизации под пользователем standard_user проверить что на странице ProductPage размер списка товаров = 6
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithValidDate(STANDARD_USER_LOGIN, PASSWORD)
                .getProductList()
                .shouldHave(size(6));
    }

    @ParameterizedTest
    @MethodSource("getInvalidAuthorizationDataAndErrorText")
    @DisplayName("Проверка появления ошибки при авторизации с невалидными данными")
    void checkFailedLogin(String login, String password, String errorText) {
        /*
         * Проверка неуспешной авторизации
         * Здесь два пути:
         * 1. Ввести несуществующие данные и попробовать авторизоваться
         * 2. Взять заблокированного пользователя и попробовать авторизоваться
         * В любом случае проверка заключается в том что в нотификации о неуспешной авторизации выводится соответствующий текст
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationWithInvalidDate(login, password)
                .getLoginErrorField().shouldBe(visible).shouldHave(text(errorText));
    }

    static Stream<Arguments> getInvalidAuthorizationDataAndErrorText() {
        return Stream.of(Arguments.of(LOCKED_OUT_USER_LOGIN, PASSWORD, "Sorry, this user has been locked out"),
                Arguments.of(NONEXISTENT_LOGIN, PASSWORD, "Username and password do not match any user in this service"),
                Arguments.of(STANDARD_USER_LOGIN, INVALID_PASSWORD, "Username and password do not match any user in this service"));
    }
}
