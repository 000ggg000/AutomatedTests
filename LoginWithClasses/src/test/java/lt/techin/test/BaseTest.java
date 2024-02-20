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
       driver.get("http://192.168.88.92");
       driver.manage().window().maximize();
    }



    @AfterEach
    void closeDown(){
       driver.close();
    }
    public static void waiting(){
        try{
            Thread.sleep(3000);

        } catch(InterruptedException e){}
    }
}
