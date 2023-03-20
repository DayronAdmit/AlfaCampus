import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NegativeTests {
    static WebDriver driver;
    private static final String EMAIL_1 = "user3@example.com";
    private static final String EMAIL_2 = "user2@example.com";
    private static final String PASSWORD_1 = "Superbowl-recipe";
    private static final String PASSWORD_2 = "require-Absorb";
    private static final String INCORRECT_PASSWORD = "Toxic-alien";
    private static final String BASE_URL = "http://qa-games.ru/";
    private static final String POSTS_PAGE_URL = "http://qa-games.ru/#/posts";


    @BeforeAll
    static void setUp() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    public void browserStart() {
        driver.get(BASE_URL);
    }

    @AfterAll
    public static void driverQuit() {
        driver.quit();
    }


    @Test
    void whenUsedIncorrectPasswordThenAlertShouldAppears() throws InterruptedException {
        FunctionalClass.logIn(EMAIL_1, INCORRECT_PASSWORD, driver);
        WebElement failureAlertAuthorisation = driver.findElement(By.xpath("//*[text()='Некорректные данные']"));
        Thread.sleep(500);
        assertTrue(failureAlertAuthorisation.isDisplayed(), "Не появляется сообщение об ошибке авторизации 'Некорректные данные'.");
    }

    @Test
    void WhenUserUnauthorizedThenHeHaveNotAccessToPosts() {
        String xpathPostsLocator = "//*[@alt]";
        driver.manage().deleteAllCookies();
        driver.get(POSTS_PAGE_URL);
        assertFalse(FunctionalClass.isElementDisplay(xpathPostsLocator, driver), "Неавторизованный пользователь имеет доступ к постам.");
    }

    @Test
    void whenTryingToDeleteSomeoneElsePostThenItShouldNotBeDeleted() throws InterruptedException {
        String newPostTitle = FunctionalClass.generateRandomString();
        String newPostBody = FunctionalClass.generateRandomString();
        FunctionalClass.logIn(EMAIL_1, PASSWORD_1, driver);
        FunctionalClass.cratePost(newPostTitle, newPostBody, driver);
        String xpathPostLocator = "//*[text()='" + newPostTitle + "']";
        Thread.sleep(500);
        driver.get("http://qa-games.ru/");
        FunctionalClass.logIn(EMAIL_2, PASSWORD_2, driver);
        FunctionalClass.deletePostByTitle(newPostTitle, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        assertTrue(FunctionalClass.isElementDisplay(xpathPostLocator, driver));
    }

    @Test
    void whenTryingToChangeSomeoneElsePostBodyThenItShouldNotBeChanged() throws InterruptedException {
        String newPostTitle = FunctionalClass.generateRandomString();
        String newPostBody = FunctionalClass.generateRandomString();
        String changedPostBody = FunctionalClass.generateRandomString();
        String xpathChangedPostLocator = "//span[text()='" + changedPostBody + "']";
        FunctionalClass.logIn(EMAIL_1, PASSWORD_1, driver);
        FunctionalClass.cratePost(newPostTitle, newPostBody, driver);
        Thread.sleep(500);
        driver.get("http://qa-games.ru/");
        FunctionalClass.logIn(EMAIL_2, PASSWORD_2, driver);
        FunctionalClass.changePostBody(newPostTitle, changedPostBody, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        assertFalse(FunctionalClass.isElementDisplay(xpathChangedPostLocator, driver), "Тело чужого поста было изменено.");
    }

    @Test
    void whenTryingToChangeSomeoneElsePostTitleThenItShouldNotBeChanged() throws InterruptedException {
        String newPostTitle = FunctionalClass.generateRandomString();
        String newPostBody = FunctionalClass.generateRandomString();
        String changedPostTitle = FunctionalClass.generateRandomString();
        String xpathChangedPostLocator = "//div[text()='" + changedPostTitle + "']";
        FunctionalClass.logIn(EMAIL_1, PASSWORD_1, driver);
        FunctionalClass.cratePost(newPostTitle, newPostBody, driver);
        Thread.sleep(500);
        driver.get("http://qa-games.ru/");
        FunctionalClass.logIn(EMAIL_2, PASSWORD_2, driver);
        FunctionalClass.changePostTitle(newPostTitle, changedPostTitle, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        assertFalse(FunctionalClass.isElementDisplay(xpathChangedPostLocator, driver), "Заголовок чужого поста был изменен.");
    }

}
