import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Allert {
    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
    }


//Drag and Drop

    @Test
    void javaScriptAlert() {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("button1"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = driver.switchTo().alert();
//        wait.until(ExpectedConditions.visibilityOf((WebElement) alert));
        String alertText = alert.getText();
        Assertions.assertEquals("I am an alert box!", alert.getText());
        driver.switchTo().alert().accept();

    }

    @Test
    void javaScriptConfirmBox() {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("button4"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = driver.switchTo().alert();
//        wait.until(ExpectedConditions.visibilityOf((WebElement) alert));
        String alertText = alert.getText();
        Assertions.assertEquals("Press a button!", alert.getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirm-alert-text")).isDisplayed();

    }

    @Test
    void modalPopup() {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("button2"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = driver.findElement(By.cssSelector(".modal-md .modal-title"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String messageText = message.getText();
        Assertions.assertEquals("It’s that Easy!! Well I think it is.....", messageText);
        driver.close();

    }

    @Test
    void ajaxLoader() {
        driver.manage().window().maximize();
        WebElement element3 = driver.findElement(By.id("button3"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click()", element3);
        element3.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button1")));
        assertTrue(driver.findElement(By.id("button1")).isDisplayed());
        driver.close();

    }


    @AfterEach
    void closeDown() {
//        driver.quit();
    }
}

