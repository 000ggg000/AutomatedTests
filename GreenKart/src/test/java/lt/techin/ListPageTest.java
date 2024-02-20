package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListPageTest extends BasePageTest {


    @Test
    void filterItems() {
        ListPage listPage = new ListPage(driver);
        listPage.sortItemsNumber();
        Assertions.assertEquals("20", listPage.value20.getText());

    }

    @Test
    void sortingItems() {
        ListPage listPage = new ListPage(driver);
        listPage.sortItemsNumber();
        Assertions.assertEquals("20", listPage.value20.getText());
        listPage.clickSortingAlphabetically();
        System.out.println(listPage.getItemsNames());
        List<String> elementsFromPage = listPage.getItemsNames();
        List<String> elementsSorted = elementsFromPage.stream().sorted().toList();
        System.out.println(elementsSorted);
        Assertions.assertEquals(elementsSorted, elementsFromPage);

    }

    @Test
    void filterSearchFunctionalityByContaining() {
        ListPage listPage = new ListPage(driver);
        listPage.sortItemsNumber();
        Assertions.assertEquals("20", listPage.value20.getText());
//        waiting();
        listPage.inputSearchbar("dr");
        List<String> listAfterFilter = listPage.elements.stream().map(w -> w.getText()).map(String::toLowerCase).toList();
       //        List<String> searchFromPage = listPage.getItemsSortedByWord("dr");
       System.out.println(listAfterFilter);
        Assertions.assertTrue(listAfterFilter.stream().allMatch(w->w.contains("dr")));


    }

    @Test
    void filterSearchFunctionalityByHavingAll() {
        ListPage listPage = new ListPage(driver);
        listPage.sortItemsNumber();
        Assertions.assertEquals("20", listPage.value20.getText());
        List<String> searchFromPage = listPage.elements.stream().map(WebElement::getText).map(String::toLowerCase).filter(text -> text.contains("dr")).toList();
        listPage.inputSearchbar("dr");
        List<String> listas = listPage.getItemsSortedByWord("dr");
        System.out.println("listas" +listas);
        List<String> listAfterFilterInPage = listPage.elements.stream().map(w -> w.getText()).map(String::toLowerCase).toList();
        System.out.println("list" + searchFromPage);
        Assertions.assertEquals(listAfterFilterInPage, searchFromPage);
        Assertions.assertEquals(listas, searchFromPage);


    }
}
