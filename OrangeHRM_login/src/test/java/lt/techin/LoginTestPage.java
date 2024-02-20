package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTestPage extends BasePageTest {


    @Test
    void loginWithValidData() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        loginPage.waiting();
//        Irasomos reiksmes:
//        loginPage.usernameInput.sendKeys("Admin");
//        loginPage.passwordInput.sendKeys("admin123");
//        loginPage.loginsubmit.click();
//        accountPage.accountSettings.click();
//        Assertions.assertEquals("Dashboard", accountPage.dashboard.getText());

        loginPage.waiting();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        loginPage.usernameInput.sendKeys(loginPage.username.getText().split(": ")[1]);
//        loginPage.passwordInput.sendKeys(loginPage.password.getText().split(": ")[1]);
        String username = loginPage.userName();
        loginPage.enterUsername(username);
        String password = loginPage.passWord();
        loginPage.enterPassword(password);
        loginPage.loginEnter();
        accountPage.accountSettings();
        accountPage.waitUntilAccountisDisplayed();
        Assertions.assertEquals("Dashboard", accountPage.dashBoardSet());
        Assertions.assertEquals("Logout", accountPage.logoutSet());
    }

    @Test
    void loginWithInvalidData() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        loginPage.waiting();
        loginPage.usernameInput.sendKeys("Admin");
        loginPage.passwordInput.sendKeys("admiin123");
        loginPage.loginsubmit.click();
        Assertions.assertEquals("Invalid credentials", loginPage.errorMessage.getText());
    }

    @Test
    void loginWithEmptyData() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        loginPage.waiting();
        loginPage.loginsubmit.click();
        Assertions.assertEquals("Required", loginPage.requiredMessage.getText());
        Assertions.assertEquals("Required", loginPage.requiredMessage2.getText());
    }

    @Test
    void logout() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        loginPage.waiting();
        String username = loginPage.userName();
        loginPage.enterUsername(username);
        String password = loginPage.passWord();
        loginPage.enterPassword(password);
        loginPage.loginEnter();
        accountPage.accountSettings();
        accountPage.accountLogout();
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", driver.getCurrentUrl());
    }

}
