package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='username']")
    WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    WebElement passwordInput;

    @FindBy(css= ".orangehrm-login-button")
    WebElement loginsubmit;

    @FindBy(xpath = "//div[contains(@class,'orangehrm-demo-credentials')]/p[1]")
    WebElement username;

    @FindBy(xpath = "//div[contains(@class,'orangehrm-demo-credentials')]/p[2]")
    WebElement password;

    @FindBy(css = ".oxd-alert-content-text")
    WebElement errorMessage;

    @FindBy(css = "[method] .oxd-form-row:nth-child(2) .oxd-input-field-error-message")
    WebElement requiredMessage;

    @FindBy(css = "[method] .oxd-form-row:nth-child(3) .oxd-input-field-error-message")
    WebElement requiredMessage2;

    public LoginPage(WebDriver driver) {

        super(driver);
    }
    public void waiting(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }
    public String userName(){
       return username.getText().split(": ")[1];

    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public String passWord(){
        return password.getText().split(": ")[1];
    }

    public void loginEnter(){
        loginsubmit.click();
    }




}
