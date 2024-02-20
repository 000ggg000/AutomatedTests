import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMyTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get( "https://uzt.lt/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.className("title"));
        element.click();
        WebElement element2 = driver.findElement(By.className("select2-search select2-search--inline"));
        element.sendKeys("Vilniaus miesto sav.");
//        element.sendKeys("Vardas Pavardenis");
    }

}
