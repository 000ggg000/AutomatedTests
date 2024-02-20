package lt.techin.OpenCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(name = "email")
    WebElement inputEmail;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(css = "[action] .btn-primary")
    WebElement submitLogin;

    @FindBy(css = ".alert-dismissible")
    WebElement alertMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }
    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void enterSubmitLogin() {
        submitLogin.click();
    }
    public String allertMessage() {
        return alertMessage.getText();
    }


}
