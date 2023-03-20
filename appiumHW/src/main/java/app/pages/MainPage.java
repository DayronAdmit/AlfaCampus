package app.pages;

import app.ContextType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MainPage extends Page {

    @AndroidFindBy(id = "org.wikipedia:id/search_container")
    private MobileElement searchField;

    @AndroidFindBy(id = "org.wikipedia:id/view_onboarding_page_indicator")
    private MobileElement onboardingScreen;

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private MobileElement inputText;

    @AndroidFindBy(id = "org.wikipedia:id/page_list_item_title")
    private List<MobileElement> searchingResults;

    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_skip_button")
    private MobileElement skipButton;

    @AndroidFindBy(id = "org.wikipedia:id/article_menu_bookmark")
    private MobileElement saveButton;

    @FindAll({
            @FindBy(xpath = "//section[@data-mw-section-id='0']/p//*[@title]"),
            @FindBy(xpath = "//table//a[not(contains(@href, './File'))][@title!='Edit this on Wikidata']"),
            @FindBy(xpath = "//section[@data-mw-section-id=1]//p//*[@href][@title!='Wikipedia:Citation needed']"),
            @FindBy(xpath = "//section[@data-mw-section-id=2]//p//*[@href][@title!='Wikipedia:Citation needed']"),
            @FindBy(xpath = "//section[@data-mw-section-id='3']/p//*[@title]"),
            @FindBy(xpath = "//section[@data-mw-section-id='5']//*[@href][@class!='pcs-ref-back-link']"),
            @FindBy(xpath = "//section[@data-mw-section-id='6']//*[@href]")
    })
    private List<WebElement> textsWithLinksIn;

    @FindBy(className = "pcs-collapse-table-collapsed-container")
    private WebElement quickFactsHeadArea;

    @FindBy(id = "References")
    private WebElement referencesHeadArea;

    public void switchContext(ContextType contextType) {
        driver.context(contextType.getContextTypeValue());
    }

    public void searchingByText(String text) {
        searchField.click();
        inputText.setValue(text);
    }

    public void checkPreview() {
        try {
            onboardingScreen.isDisplayed();
            skipButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickOnResult(String value) {
        searchingResults.stream()
                .filter(t -> t.getText().equals(value))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Результата с именем '%s' не найдено на странице", value))).click();
    }

    public void showInfoAboutTextsWithLink() throws InterruptedException {
        List<WebElement> textsWithLinksList = new ArrayList<>();
        Thread.sleep(3000);
        switchContext(ContextType.WEBVIEW);
        quickFactsHeadArea.click();
        referencesHeadArea.click();
        String sequenceOfTextsWithLinks = textsWithLinksIn.stream().map(WebElement::getText).collect(Collectors.joining(", "));
        System.out.printf("Всего текстов со ссылками %d. А именно: [%s]\n", textsWithLinksIn.size(), sequenceOfTextsWithLinks);
        switchContext(ContextType.NATIVE);
    }
}