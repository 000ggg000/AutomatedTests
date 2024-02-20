package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".oxd-userdropdown-img")
    WebElement accountSettings;

    @FindBy(css= "li:nth-of-type(4) > a[role='menuitem']" )
    WebElement logout;

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    WebElement dashboard;


    public void accountSettings(){
        accountSettings.click();
    }

    public void accountLogout(){
        logout.click();
    }

    public void waitUntilAccountisDisplayed(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(p -> logout.isDisplayed());
    }

    public String logoutSet(){
        return logout.getText();
    }

    public String dashBoardSet(){
        return dashboard.getText();
    }
}

