import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginOpenCart {
    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.get("http://192.168.88.92");
    }


//sukurti esamo vartotojo login automatinius testus OpenCart psl( pozityvus ir negatyvus testas.)

    @Test
    void loginValidData() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".float-end.nav > .list-inline .dropdown-toggle > .d-md-inline.d-none")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right.show > li:nth-of-type(2) > .dropdown-item")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.name("email")).sendKeys("blah@email.com");
        driver.findElement(By.name("password")).sendKeys("blabla");
        driver.findElement(By.cssSelector("[action] .btn-primary")).submit();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.linkText("Account")).isDisplayed();

    }

    @Test
    void loginInvalidData() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".float-end.nav > .list-inline .dropdown-toggle > .d-md-inline.d-none")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right.show > li:nth-of-type(2) > .dropdown-item")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.name("email")).sendKeys("bla@email.com");
        driver.findElement(By.name("password")).sendKeys("blabli");
        driver.findElement(By.cssSelector("[action] .btn-primary")).submit();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        String error = driver.findElement(By.cssSelector(".alert-dismissible")).getText();
        System.out.println(error);
        Assertions.assertEquals("Warning: No match for E-Mail Address and/or Password.", error);

    }

    @Test
    void submitEmptyForm() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.cssSelector("[action] .btn-primary")).submit();
        String error = driver.findElement(By.cssSelector(".alert-dismissible")).getText();
        System.out.println(error);
        Assertions.assertEquals("Warning: No match for E-Mail Address and/or Password.", error);
    }


    @AfterEach
    void closeDown() {
        driver.quit();
    }
}
