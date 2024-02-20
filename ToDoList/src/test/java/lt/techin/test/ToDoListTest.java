package lt.techin.test;

import lt.techin.OpenCart.pages.ToDoList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class ToDoListTest extends BaseTest {

    @Test
    void addTask() {
        ToDoList toDoList = new ToDoList(driver);
        toDoList.enterElement("what a wonderful day");
        Assertions.assertEquals("what a wonderful day", toDoList.insertedElement());

    }

    @Test
    void ifCompletedTask() {
        ToDoList toDoList = new ToDoList(driver);
        toDoList.enterElement("what a wonderful day");
//        Assertions.assertEquals("what a wonderful day", toDoList.insertedElement());
        toDoList.checkTheTaskDone();
//        System.out.println(toDoList.insertedElement().contains());
        System.out.println(toDoList.insertedElement());
        System.out.println(toDoList.completedElement());
        Assertions.assertEquals(toDoList.insertedElement(), toDoList.completedElement());


        System.out.println("kiti irasai" + toDoList.notCompletedElements("what a wonderful day"));

        Assertions.assertTrue(toDoList.notCompletedElements("what a wonderful day"));
//        Assertions.assertEquals(toDoList.notCompletedElements("what a wonderful day"));

    }

    @Test
    void deleteTask() {
        ToDoList toDoList = new ToDoList(driver);
        toDoList.enterElement("what a wonderful day");
        Assertions.assertEquals("what a wonderful day", toDoList.insertedElement());
        toDoList.checkTheTaskDone();
        toDoList.clicktrash();
        waiting();
        Assertions.assertNotEquals("what a wonderful day", toDoList.insertedElement());

    }
}
