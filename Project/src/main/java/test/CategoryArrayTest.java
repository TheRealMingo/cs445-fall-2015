package test;

import sad.entities.Category;
import sad.entities.CategoryArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anthony on 11/22/2015.
 */
public class CategoryArrayTest {
    private Category c0 = new Category("History");
    private Category c1 = new Category("Art");
    private Category c2 = new Category("Martial Arts");
    private Category c3 = new Category("Mathematics");
    private Category c4 = new Category("Literature");

    @Test
    public void testCanAddCategoriesToCategoryArray(){
        CategoryArray cA = new CategoryArray();
        cA.addCategory(c0);
        cA.addCategory(c1);
        cA.addCategory(c2);
        Category[] expected = {c0, c1, c2};
        Category[] actual = cA.obtainAllCategories();
        assertArrayEquals("Can add categories to category array", expected, actual);
    }

    @Test
    public void testCanModifyACategoryInCategoryArray(){
        CategoryArray cA = new CategoryArray();
        cA.addCategory(c0);
        cA.addCategory(c1);
        cA.addCategory(c2);
        cA.addCategory(c3);
        cA.addCategory(c4);

        Category c = cA.getCategory(2);
        c.setCategoryGenre("Korean Martial Arts");

        assertEquals("main.entities.Category in category array can be modified", "Korean Martial Arts", cA.getCategory(2).getCategoryGenre());
    }

    @Test
    public void testCanRemoveCategoryInCategoryArray(){
        CategoryArray cA = new CategoryArray();
        cA.addCategory(c0);
        cA.addCategory(c1);
        cA.addCategory(c2);
        cA.addCategory(c3);
        cA.addCategory(c4);

        cA.removeCategoryAtPos(2);
        Category[] expected = {c0, c1, c3, c4};
        Category[] actual = cA.obtainAllCategories();
        assertArrayEquals("main.entities.Category in category array can be removed", expected, actual);
    }
}
