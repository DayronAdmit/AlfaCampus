import org.openqa.selenium.*;

import java.util.Random;

public class FunctionalClass {
    public static void logIn(String login, String password, WebDriver driver) {
        WebElement authorizationFormBtn = driver.findElement(By.xpath("//span[text()='Авторизация']"));
        authorizationFormBtn.click();
        WebElement inputEmail = driver.findElement(By.xpath("//input[@aria-label='Email']"));
        inputEmail.sendKeys(login);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@aria-label='Пароль']"));
        inputPassword.sendKeys(password);
        WebElement authorizationBtn = driver.findElement(By.xpath("//span[text()='Войти']"));
        authorizationBtn.click();
    }


    public static void cratePost(String postTitle, String postBody, WebDriver driver) {
        WebElement createPostBtn = driver.findElement(By.xpath("//span[text()='Добавить новый пост']"));
        createPostBtn.click();
        WebElement inputPostTitle = driver.findElement(By.xpath("//input[@aria-label='Название поста']"));
        inputPostTitle.sendKeys(postTitle);
        WebElement inputPostBody = driver.findElement(By.xpath("//div//textarea"));
        inputPostBody.sendKeys(postBody);
        WebElement createBtn = driver.findElement(By.xpath("//span[text()='Создать']"));
        createBtn.click();
    }

    public static void deletePostByTitle(String postTitle, WebDriver driver) {
        WebElement deletePostBtn = driver.findElement(By.xpath("//div[text()='" + postTitle + "']/..//span[text()='Удалить']"));
        deletePostBtn.click();
        WebElement confirmDeletePostBtn = driver.findElement(By.xpath("//div[text()='Удаление поста']/../..//span[text()='Удалить']"));
        confirmDeletePostBtn.click();
    }

    public static void changePostBody(String postTitle, String postNewBody, WebDriver driver) {
        WebElement editePostBtn = driver.findElement(By.xpath("//div[text()='" + postTitle + "']/..//span[text()='Редактировать']"));
        editePostBtn.click();
        WebElement bodyPostInput = driver.findElement((By.xpath("//div[@data-simplebar='init']//textarea")));
        for (int i = 0; i < 17; i++)
            bodyPostInput.sendKeys(Keys.BACK_SPACE);
        bodyPostInput.sendKeys(postNewBody);
        WebElement saveChangeBtn = driver.findElement(By.xpath("//span[text()='Сохранить']"));
        saveChangeBtn.click();
    }

    public static void changePostTitle(String postTitle, String postNewTitle, WebDriver driver) {
        WebElement editePostBtn = driver.findElement(By.xpath("//div[text()='" + postTitle + "']/..//span[text()='Редактировать']"));
        editePostBtn.click();
        WebElement titlePostInput = driver.findElement((By.xpath("//input[@aria-label='Название поста']")));
        for (int i = 0; i < 17; i++)
            titlePostInput.sendKeys(Keys.BACK_SPACE);
        titlePostInput.sendKeys(postNewTitle);
        WebElement saveChangeBtn = driver.findElement(By.xpath("//span[text()='Сохранить']"));
        saveChangeBtn.click();
    }

    public static String generateRandomString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return "TestDA " + buffer.toString();
    }

    static boolean isElementDisplay(String xpathLocator, WebDriver driver) {
        boolean isDisplay = false;
        try {
            if (driver.findElement(By.xpath(xpathLocator)).isDisplayed()) {
                isDisplay = true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e + " Не удалось найти элемент по " + xpathLocator);
        }
        return isDisplay;
    }

}
