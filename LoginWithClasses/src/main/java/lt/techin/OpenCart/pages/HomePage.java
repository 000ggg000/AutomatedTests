package lt.techin.OpenCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
@FindBy(css = ".float-end.nav > .list-inline .dropdown-toggle > .d-md-inline.d-none")
    WebElement dropdownLogin;
//    By dropdownLogin = By.cssSelector(".float-end.nav > .list-inline .dropdown-toggle > .d-md-inline.d-none");
@FindBy(css = ".dropdown-menu.dropdown-menu-right.show > li:nth-of-type(2) > .dropdown-item")
WebElement linkLogin;



    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void clickDropdownMyAccount(){
//        driver.findElement(dropdownLogin).click();
        dropdownLogin.click();
    }

    public void clickLinkLogin() {
        linkLogin.click();
    }
}
