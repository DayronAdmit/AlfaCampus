import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class BaseTest {

    protected final static String STANDARD_USER_LOGIN = "standard_user";
    protected final static String LOCKED_OUT_USER_LOGIN = "locked_out_user";
    protected final static String NONEXISTENT_LOGIN = "random_user";
    protected final static String PASSWORD = "secret_sauce";
    protected final static String INVALID_PASSWORD = "IM_NOT_WORKING";
    protected static String customerName = "Ivan";
    protected static String customerLastName = "Ivanov";
    protected static String customerPostalCode = "129921";

    @BeforeAll
    static void setUp() {
        Configuration.timeout = 3000;
        Configuration.baseUrl = "https://www.saucedemo.com/";
    }

    @BeforeEach
    void beforeTest() {
        if (hasWebDriverStarted()) {
            getWebDriver().manage().deleteAllCookies();
        }
        open("");
    }

    @AfterEach
    void afterTest() {
        getWebDriver().manage().deleteAllCookies();
    }
}
