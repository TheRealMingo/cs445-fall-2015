import org.junit.Test;
import exceptions.CategoryMustHaveGenreException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class CategoryTests {
    @Test(expected = CategoryMustHaveGenreException.class)
    public void testCategoryMustHaveName() throws CategoryMustHaveGenreException {
        Category c = new Category();
        System.out.println("Category must have name exception is thrown.");
    }

    @Test
    public void testCategoryHaveName(){
        Category c = new Category("Comedy");
        String genre = c.obtainGenre();
        assertEquals("Category does have genre", "Comedy", genre);
    }

    @Test
    public void testCanUpdateCategoryGenre(){
        Category c = new Category("Comedy");
        c.updateGenre("Documentary");
        String genre = c.obtainGenre();
        assertEquals("Category genre can be updated", "Documentary", genre);
    }

    @Test
    public void testCategoryCanHaveASubCategory(){
        Category c = new Category("Comedy");
        c.giveSubcategory("Kids");
        String[] subcategory = c.obtainSubcategoriesNames();
        assertEquals("Subcategory length for one subcategory should be 1", 1, subcategory.length);
        assertEquals("Category can have subcategory", "Kids", subcategory[0]);
    }

    @Test
    public void testCategoryCanHaveMultipleSubCategories(){
        Category c = new Category("Comedy");
        c.giveSubcategory("Adult");
        c.giveSubcategory("Kids");
        c.giveSubcategory("Historical");
        String[] subcategories = c.obtainSubcategoriesNames();
        String[] expected = {"Adult", "Kids", "Historical"};
        assertArrayEquals("Category can have multiple subcategories", expected, subcategories);
    }

}
