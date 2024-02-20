package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListPage extends BasePage {

    @FindBy(id = "page-menu")
    WebElement sorting;

    @FindBy(css = "[value='20']")
    WebElement value20;

    @FindBy(css = "th:nth-of-type(1)")
    WebElement sortingalphabetically;

    @FindBy(css = "tr td:first-child")
    List<WebElement> elements;

    @FindBy(id = "search-field")
    WebElement searchBar;


    public ListPage(WebDriver driver) {

        super(driver);
    }

    public void waiting() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void sortItemsNumber() {
        sorting.click();
        value20.click();


    }

    public void clickSortingAlphabetically() {
        sortingalphabetically.click();
    }

    public List<String> getItemsNames() {

        //      List<WebElement> elements = driver.findElements(By.cssSelector("tbody > tr:nth-of-type(1)"));

        return elements.stream().map(WebElement::getText).toList();

//        ArrayList<String> names = new ArrayList<>();
//        for (WebElement element : elements) {
//            names.add(element.getText());
//        }

    }


    public void inputSearchbar(String word) {
        searchBar.sendKeys(word);
    }

    public List<String> getItemsSortedByWord(String word) {

//        elements.stream().map(WebElement::getText)..toList();
        return elements.stream().map(w -> w.getText()).map(String::toLowerCase).filter(w->w.contains(word)).toList();
        }
}
