import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class PositiveTests {
    static WebDriver driver;
    private static final String EMAIL_1 = "user3@example.com";
    private static final String PASSWORD_1 = "Superbowl-recipe";
    private static final String BASE_URL = "http://qa-games.ru/";


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
    void RegistrationWithTrueEmailAndPasswordTest() throws InterruptedException {
        String name = "Джон";
        String lastName = "Траволта";
        String eMail = "ures0@example.com";
        String password = "Toxic-alien";
        WebElement inputName = driver.findElement(By.xpath("//input[@name='firstName']"));
        WebElement inputLastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        WebElement inputEMail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement registrationBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEMail.sendKeys(eMail);
        inputPassword.sendKeys(password);
        registrationBtn.click();
        String xpathPostsLocator = "//*[@alt]";
        assertTrue(FunctionalClass.isElementDisplay(xpathPostsLocator, driver), "Пользователю недоступен просмотр постов");
    }


    @Test
    void authorizedUserSeesListOfPosts() {
        FunctionalClass.logIn(EMAIL_1, PASSWORD_1, driver);
        String xpathPostsLocator = "//*[@alt]";
        assertTrue(FunctionalClass.isElementDisplay(xpathPostsLocator, driver), "Пользователю недоступен просмотр постов");
    }

    @Test
    void WhenCreatePostThenItShouldAppearOnThePostsPage() throws InterruptedException {
        String newPostTitle = FunctionalClass.generateRandomString();
        String newPostBody = FunctionalClass.generateRandomString();
        FunctionalClass.logIn(EMAIL_1, PASSWORD_1, driver);
        FunctionalClass.cratePost(newPostTitle, newPostBody, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        WebElement post = driver.findElement(By.xpath("//div[text()='" + newPostTitle + "']"));
        assertEquals(post.getText(), newPostTitle, "Созданный пост не найден.");
    }

    @Test
    void WhenDeleteSelfPostThenItShouldNotExist() throws InterruptedException {
        String newPostTitle = FunctionalClass.generateRandomString();
        String newPostBody = FunctionalClass.generateRandomString();
        String xpathPostLocator = "//*[text()='" + newPostTitle + "']";
        FunctionalClass.logIn(EMAIL_1, PASSWORD_1, driver);
        FunctionalClass.cratePost(newPostTitle, newPostBody, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        FunctionalClass.deletePostByTitle(newPostTitle, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        assertFalse(FunctionalClass.isElementDisplay(xpathPostLocator, driver));
    }

    @Test
    void WhenChangSelfPostBodyThenItShouldChanged() throws InterruptedException {
        String newPostTitle = FunctionalClass.generateRandomString();
        String newPostBody = FunctionalClass.generateRandomString();
        String changedPostBody = FunctionalClass.generateRandomString();
        FunctionalClass.logIn(EMAIL_1, PASSWORD_1, driver);
        FunctionalClass.cratePost(newPostTitle, newPostBody, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        FunctionalClass.changePostBody(newPostTitle, changedPostBody, driver);
        Thread.sleep(500);
        driver.navigate().refresh();
        String xpathChangedPostLocator = "//span[text()='" + changedPostBody + "']";
        assertTrue(FunctionalClass.isElementDisplay(xpathChangedPostLocator, driver));
    }

}


