import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static java.time.Duration.ofSeconds;

public class Exercise2 {
    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.get("http://192.168.88.92/");
    }

//    3.Enter a wrong product name in Search field (F.e: MaxBook).

    @Test
    void exercise2() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
//        3.Enter a wrong product name in Search field (F.e: MaxBook)
        driver.findElement(By.name("search")).sendKeys("MaxBook");
//        4.Click button.
        driver.findElement(By.cssSelector(".btn-light")).click();
//        search.sendKeys(Keys.ENTER);
        // 5.Check if button.button is displayed.
        driver.findElement(By.id("button-search")).isDisplayed();
//    6.Clear first Search field and enter the correct product name (F.e.: Macbook).
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("MacBook");
//        7.Click button again.
        driver.findElement(By.cssSelector(".btn-light")).click();
//        8.Count the number of searched items.
        System.out.println(driver.findElements(By.cssSelector("h4")).size());
//        9.Select sort filter
        Select priceValue = new Select(driver.findElement(By.id("input-sort")));
        Actions goTo = new Actions(driver);
        WebElement desktops=driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > a"));

        goTo.moveToElement(desktops).perform();
//        priceValue.selectByValue("http://192.168.88.92/en-gb?route=product/search&sort=p.price&order=ASC&search=MacBook");

       priceValue.selectByVisibleText("Price (Low > High)");
//        System.out.println(priceValue.selectByVisibleText("Price (Low > High)"));
//        priceValue.selectByIndex(3);
//        System.out.println(priceValue.selectByIndex(4));

//        driver.findElement(By.id("input-sort")).sendKeys(Keys.ENTER);
//        10.Retrieve selected option text and print it.

//        String text = driver.findElement(By.id("input-sort")).getText();
        WebElement itemsPerPage2 = driver.findElement(By.id("input-sort"));
        Select select2=new Select(itemsPerPage2);
        WebElement text2 = select2.getFirstSelectedOption();


        System.out.println(text2.getText());

//        11.Close Browser;
        driver.quit();
    }


//    @AfterEach
//    void closeDown() {
//        driver.quit();
//    }
}

