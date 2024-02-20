package lt.techin.test;

import lt.techin.OpenCart.pages.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {


    @Test
    void loginWithValidData() {
        HomePage homePage = new HomePage(driver);
        homePage.clickDropdownMyAccount();
        homePage.clickLinkLogin();


    }
}
