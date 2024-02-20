package lt.techin.OpenCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoList extends BasePage {
    public ToDoList(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input")
    private WebElement inputElement;

    @FindBy(xpath = "//div[@id='container']/ul/li[last()]")
    WebElement insertedElement;

    @FindBy(xpath = "//li[@class=\'completed\']")
    WebElement completedElement;

    @FindBy(css = "ul li:nth-of-type(4) .fa-trash")
    WebElement trashButton;

    @FindBy(xpath = "//li//span")
    List<WebElement> elementsList;
    public void enterElement(String name) {
        inputElement.sendKeys(name);
        inputElement.sendKeys(Keys.ENTER);
    }

    public String insertedElement() {
        return insertedElement.getText();
    }
    public String completedElement() {
        return completedElement.getText();
    }

    public boolean notCompletedElements(String element) {
        elementsList.stream().filter(w->!w.getText().contains(element)).forEach(e-> System.out.println(e.getText()));
        return elementsList.stream().filter(w->!w.getText().contains(element)).noneMatch(e-> e.getAttribute("class").contains("completed"));



    }
    public void checkTheTaskDone(){
        Actions action = new Actions(driver);
        action.click(insertedElement).perform();
    }

    public void clicktrash() {
        trashButton.click();
    }
}
