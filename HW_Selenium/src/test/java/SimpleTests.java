import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTests {

    static WebDriver driver;

    static String inputText = "Freeedom!";

    @BeforeAll
    public static void setUp() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("http://qa-games.ru/");
        driver.get("https://www.google.ru/");
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    void checkWebPageIsOpen() {
        String url = driver.getCurrentUrl();
        assertEquals(url, "http://qa-games.ru/", "Открылся не тот сайт");
    }

    @Test
    void checkInputText() {
        WebElement inputName = driver.findElement(By.xpath("//input[@name='firstName']"));
        inputName.sendKeys(inputText);
        String expectedTextIn = inputName.getAttribute("Value");
        assertEquals(expectedTextIn, inputText, "Текст в поле ввода не соответствует ожидаемому.");
    }

    @Test
    void whenClickToRegistrationBtnWith3EmptyFieldsThen3AlertsShouldAppear() {
        WebElement inputName = driver.findElement(By.xpath("//input[@name='firstName']"));
        WebElement registrationBtn = driver.findElement(By.xpath("//form//button"));
        inputName.sendKeys(inputText);
        registrationBtn.click();
        List<WebElement> requiredFieldAlerts = driver.findElements(By.xpath("//form//*[@role='alert']"));
        assertEquals(requiredFieldAlerts.size(), 3, "Количество всплывающих сообщений об обязательности заполнения полей несоотвествует ожидаемому");
    }

}
