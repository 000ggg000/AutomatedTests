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

public class TestOpenCart {
    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.get("http://192.168.88.92/");
    }

    //    3. Click on a wishlist
    @Test
    void userWishList() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
    }

    //    4. Count and print a number of seach boxes
    @Test
    void countPrintNumBoxes() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.stream().filter(WebElement::isDisplayed).count());


//    int count = 0;
//    for(WebElement e: inputs){
//        if(e.isDisplayed()){
//            count++;
//        }
//    }
        //    praeina pro visus laukus ir iveda "aaaaa" i visus laukus:
//    inputs.stream().filter(WebElement::isDisplayed).forEach((e->e.sendKeys("aaaaa")));
    }

//5. Find element of email input field and enter email “email@email.com”

    @Test
    void putEmail() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.name("email")).sendKeys("email@email.com");
    }

    //    6. Clear previous field
    @Test
    void clearEmail() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.name("email")).clear();
    }

    //7. Submit form
    @Test
    void submitForm() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.cssSelector("[action] .btn-primary")).submit();
        String error = driver.findElement(By.cssSelector(".alert-dismissible")).getText();
        System.out.println(error);
        Assertions.assertEquals("Warning: No match for E-Mail Address and/or Password.", error);
    }

    //8.Click on register a new customer
    @Test
    void registerCustomer() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.linkText("Continue")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/register", driver.getCurrentUrl());

    }

    //    9.Check if the field to input password is enabled and print the result
    @Test
    void enabledInput() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.linkText("Continue")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/register", driver.getCurrentUrl());
        driver.findElement(By.name("firstname")).isEnabled();

    }

    //10.Check if cart element is displayed and print the result
    @Test
    void elementDisplayed() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.linkText("Continue")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/register", driver.getCurrentUrl());

        WebElement cartElement = driver.findElement(By.cssSelector(".btn-inverse"));
        System.out.println(cartElement.isDisplayed());
//        System.out.println(cartElement);
//        String cartElement = driver.findElement(By.cssSelector(".btn-inverse")).getText();
//        System.out.println(cartElement);

    }

    //    11.Check if agree checkbox is selected and print the resul
    @Test
    void agreeBoxSelected() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.linkText("Continue")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/register", driver.getCurrentUrl());
        WebElement checked = driver.findElement(By.cssSelector("input[name='agree']"));
        Assertions.assertFalse(checked.isSelected());
        System.out.println(checked.isSelected());

    }

    //12.Go to top menu -> Desktops
    @Test
    void goToDesktop() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector(".list-inline > li:nth-of-type(3)")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
        driver.findElement(By.linkText("Continue")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/register", driver.getCurrentUrl());
        driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb/catalog/desktops", driver.getCurrentUrl());
    }

    //13.Select to show 25 items per page
    @Test
    void showItemsPerPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb/catalog/desktops", driver.getCurrentUrl());
        Select dropDown = new Select(driver.findElement(By.id("input-limit")));
        dropDown.selectByValue("http://192.168.88.92/en-gb/catalog/desktops?limit=25");

    }

//    14. Print selected option from the dropbox

    @Test
    void selectedOptionFromDropbox() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb/catalog/desktops", driver.getCurrentUrl());
        Select dropDown = new Select(driver.findElement(By.id("input-limit")));
        System.out.println("dropDown.selectByValue(\"http://192.168.88.92/en-gb/catalog/desktops?limit=25\")");

    }

    //    15.Select 4th option in show items per page dropbox
    @Test
    void selectForthOptionFromThePage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb/catalog/desktops", driver.getCurrentUrl());
        Select dropDown = new Select(driver.findElement(By.id("input-limit")));
        dropDown.selectByValue("http://192.168.88.92/en-gb/catalog/desktops?limit=25");
        driver.findElement(By.cssSelector("div#product-list > div:nth-of-type(4)")).click();

    }

//    16.Print selected option

    @Test
    void printSelectedOption() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();
        Assertions.assertEquals("http://192.168.88.92/en-gb/catalog/desktops", driver.getCurrentUrl());
        Select dropDown = new Select(driver.findElement(By.id("input-limit")));
        dropDown.selectByValue("http://192.168.88.92/en-gb/catalog/desktops?limit=25");
        driver.findElement(By.cssSelector("div#product-list > div:nth-of-type(4)")).click();
        System.out.println(driver.findElement(By.cssSelector("div#product-info")));
//        System.out.println(driver.findElement(By.cssSelector("div#product-list > div:nth-of-type(4)")));
    }

//17.Close the window
@Test
void closeWindow() {
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link")).click();
    driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();
    Assertions.assertEquals("http://192.168.88.92/en-gb/catalog/desktops", driver.getCurrentUrl());
    Select dropDown = new Select(driver.findElement(By.id("input-limit")));
    dropDown.selectByValue("http://192.168.88.92/en-gb/catalog/desktops?limit=25");
    driver.findElement(By.cssSelector("div#product-list > div:nth-of-type(4)")).click();
    driver.close();
}

    @AfterEach
    void closeDown() {
        driver.quit();
    }
}
