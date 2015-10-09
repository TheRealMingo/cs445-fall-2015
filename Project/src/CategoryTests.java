import org.junit.Test;
import exceptions.CategoryMustHaveGenreException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
    public void testCategoryCanHaveSubCategory(){
        Category c = new Category("Comedy");
        c.giveSubcategory("Kids");
        String subcategory = c.obtainSubcategory();
        assertEquals("Category can have subcategory", "Kids", subcategory);
    }


}
