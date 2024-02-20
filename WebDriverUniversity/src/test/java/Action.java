import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Action {
    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://webdriveruniversity.com/Actions/index.html");
    }


//Drag and Drop

    @Test
    void actionDragAndDrop() {
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        System.out.println(driver.findElement(By.id("droppable")).getCssValue("background"));
        WebElement button = driver.findElement(By.id("draggable"));
        WebElement area = driver.findElement(By.id("droppable"));
        action.dragAndDrop(button, area).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String color = driver.findElement(By.id("droppable")).getCssValue("background");
        System.out.println(color);
//        wait.until(d -> driver.findElement(By.id("droppable")).getAttribute("background"));
        assertEquals(driver.findElement(By.cssSelector("div#droppable > p")).getCssValue("background-color"), "rgba(244, 89, 80, 1)");
        assertEquals(driver.findElement(By.cssSelector("div#droppable > p > b")).getText(), "Dropped!");
        System.out.println(driver.findElement(By.id("droppable")).getCssValue("background"));


    }

    //        2. Double click

    @Test
    void doubleClick() {
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement area1 = driver.findElement(By.id("double-click"));
        action.doubleClick(area1).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String color = driver.findElement(By.id("double-click")).getAttribute("background-color");
        Assertions.assertEquals(driver.findElement(By.id("double-click")).getCssValue("background-color"), "rgba(147, 203, 90, 1)");


    }

    //    3. Hover over me
    @Test
    void hoverOverMe() {

//        first hover link:
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement area = driver.findElement(By.className("dropdown"));
        action.moveToElement(area).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement area2 = driver.findElement(By.xpath("//div[@id='div-hover']/div[1]//a[@href='#']"));
        action.moveToElement(area2).click().perform();
//        String color = driver.findElement(By.id("droppable")).getAttribute("background-color");
//        Assertions.assert;
//        WebElement message3 = driver.findElement(By.cssSelector("body [role='dialog']:nth-child(7) .modal-title"));
//        wait.until(ExpectedConditions.visibilityOf(message3));
//        String message3Text = message3.getText();
//        System.out.println(message3Text);
//        assertTrue(message3Text.contains("Well done!"));
        Alert alert = driver.switchTo().alert();
//      wait.until(ExpectedConditions.visibilityOf((WebElement) alert));
        String alertText = alert.getText();
        Assertions.assertEquals("Well done you clicked on the link!", alert.getText());
        assertTrue(alertText.contains("Well done "));
        driver.switchTo().alert().accept();

//        second hover link:

        WebElement area3 = driver.findElement(By.cssSelector("div:nth-of-type(2) > .dropbtn"));
        action.moveToElement(area3).click().perform();
        WebElement area4 = driver.findElement(By.xpath("//div[@id='div-hover']/div[2]//a[@href='#']"));
        action.moveToElement(area4).click().perform();
        Alert alert2 = driver.switchTo().alert();
        Assertions.assertEquals("Well done you clicked on the link!", alert.getText());
        assertTrue(alertText.contains("Well done "));
        driver.switchTo().alert().accept();

//        third hoverlink
        WebElement area5 = driver.findElement(By.cssSelector("div:nth-of-type(3) > .dropbtn"));
        action.moveToElement(area5).click().perform();
        WebElement area6 = driver.findElement(By.xpath("//div[@id='div-hover']/div[3]/div/a[1]"));
        area6.click();
        driver.switchTo().alert().accept();

        action.moveToElement(area5).click().perform();
        WebElement area7 = driver.findElement(By.xpath("//div[@id='div-hover']/div[3]/div/a[2]"));
        action.moveToElement(area7).click().perform();
        Assertions.assertEquals("Well done you clicked on the link!", alert.getText());
        assertTrue(alertText.contains("Well done "));
        driver.switchTo().alert().accept();
    }


//    4. click and hold

    @Test
    void clickAndHold() {
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement area3 = driver.findElement(By.id("click-box"));
        WebElement color1 = driver.findElement(By.id("click-box"));
        action.clickAndHold(area3).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement color2 = driver.findElement(By.id("click-box"));
//        wait.until(d -> driver.findElement(By.id("click-box")).getAttribute("background"));

        System.out.println(color1.getCssValue("background"));
        System.out.println(color2.getCssValue("background"));
        assertEquals(color1, color2);


    }

    @AfterEach
    void closeDown() {
        driver.quit();
    }
}
