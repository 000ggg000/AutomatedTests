package lt.techin.test;

import lt.techin.OpenCart.pages.HomePage;
import lt.techin.OpenCart.pages.LoginPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    void userCanLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickDropdownMyAccount();
        homePage.clickLinkLogin();
        loginPage.enterEmail("aa@aa.aa");
        loginPage.enterPassword("aaaaaa");
        driver.findElement(By.cssSelector("[action] .btn-primary")).submit();
        //loginPage.enterSubmitLogin();
//        Thread.sleep(3000);
        waiting();
        Assertions.assertNotEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());

    }

    @Test
    void userCantLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickDropdownMyAccount();
        homePage.clickLinkLogin();
        loginPage.enterEmail("bla@email.com");
        loginPage.enterPassword("blabli");
        loginPage.enterSubmitLogin();
//      Assertions.assertEquals("http://192.168.88.92/en-gb?route=account/login", driver.getCurrentUrl());
//        Thread.sleep(3000);
        waiting();
        loginPage.allertMessage();
        System.out.println(loginPage.allertMessage());
        Assertions.assertEquals("Warning: No match for E-Mail Address and/or Password.", loginPage.allertMessage());
    }
}
