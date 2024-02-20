import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class TestSwag {
    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    void testSwag() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));

        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");
        WebElement element2 = driver.findElement(By.id("password"));
        element2.sendKeys("secret_sauce");
//        WebElement element3 = driver.findElement(By.id("login-button"));
//        element3.click();
        driver.findElement(By.id("login-button")).click();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        assertTrue(driver.findElement(By.className("shopping_cart_link")).isDisplayed());

    }

    @Test
    void testSwagWrongParameters() {


        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.xpath("//div[@id='login_button_container']//form//h3")).getText();
        System.out.println("Gavom: " + error);
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", error);

    }

    @Test
    void userIslockedOut() {


        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String error2 = driver.findElement(By.xpath("//div[@id='login_button_container']//form//h3")).getText();
        System.out.println("Gavom: " + error2);
        assertTrue(error2.contains("this user has been locked out"));

    }

//    @ParameterizedTest
//    @ValueSource(strings = {})
//    void voidpalindromes ( String name){
//        assertTrue(StringUtils.isPalindrome(name));
//    }


    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/logins.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String USER_NAME, String PASSWORD) {
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys(USER_NAME);

        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-button")).click();
        assertNotNull(USER_NAME);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/logins.csv", numLinesToSkip = 1)
    void testPer(String USER_NAME, String PASSWORD) {
        assertTimeout(ofSeconds(2), () -> {

            driver.manage().timeouts().implicitlyWait(ofSeconds(5));
            driver.findElement(By.id("user-name")).sendKeys(USER_NAME);

            driver.findElement(By.id("password")).sendKeys(PASSWORD);
            driver.findElement(By.id("login-button")).click();
            assertNotNull(USER_NAME);

        });
    }


    @AfterEach
    void closeDown() {
        driver.quit();
    }
}
