import app.pages.MainPage;
import app.pages.MainPage2;
import org.junit.jupiter.api.Test;

public class FirstSimpleTest extends BaseTest {

    private static final String CITY = "Lakhdenpokhya";

    MainPage mainPage = new MainPage();
    MainPage2 mainPage2 = new MainPage2();

    @Test
    void basicTest() {
        mainPage.loadPage(driver);
        mainPage.checkPreview();
        mainPage.searchingByText(CITY);
        mainPage.clickOnResult(CITY);
        assertTrue(mainPage.checkSaveButton(), "Кнопка Save не видна.");
    }

    @Test
    void getAllTextsWithLinkTest() throws InterruptedException {
        mainPage.loadPage(driver);
        mainPage.checkPreview();
        mainPage.searchingByText(CITY);
        mainPage.clickOnResult(CITY);
        mainPage.showInfoAboutTextsWithLink();
    }
}