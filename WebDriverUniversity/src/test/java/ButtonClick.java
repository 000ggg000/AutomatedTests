import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonClick {
    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
    }


//Drag and Drop

    @Test
    void webElementClick() {
        driver.manage().window().maximize();
        driver.findElement(By.id("button1")).click();
//        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement congratulations = driver.findElement(By.cssSelector("body [role='dialog']:nth-child(5) .modal-title"));
        wait.until(ExpectedConditions.visibilityOf(congratulations));
        String congratulationsText = congratulations.getText();
        System.out.println("text" + congratulationsText);
        assertTrue(congratulationsText.contains("Congrat"));

    }

    @Test
    void javaScriptClick() {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("button2"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = driver.findElement(By.cssSelector(".modal-md .modal-title"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String messageText = message.getText();
        Assertions.assertTrue(messageText.contains("that Easy!!"));

    }

    @Test
    void actionMoveAndClick() {
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement button = driver.findElement(By.id("button3"));
        action.moveToElement(button).click(button).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message3 = driver.findElement(By.cssSelector("body [role='dialog']:nth-child(7) .modal-title"));
        wait.until(ExpectedConditions.visibilityOf(message3));
        String message3Text = message3.getText();
        System.out.println(message3Text);
        assertTrue(message3Text.contains("Well done!"));



    }


    @AfterEach
    void closeDown() {
        driver.quit();
    }
}
