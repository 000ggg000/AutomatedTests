package lt.techin.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

   @BeforeEach
   void setup(){
        driver = new ChromeDriver();
       driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
       driver.manage().window().maximize();
    }



    @AfterEach
    void closeDown(){
//    driver.quit();
    }
    public static void waiting(){
        try{
            Thread.sleep(3000);

        } catch(InterruptedException e){}
    }
}
