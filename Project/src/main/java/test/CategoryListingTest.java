package test;

import sad.entities.Category;
import sad.entities.CategoryListing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class CategoryListingTest {
    @Test
    public void testCategoryListingHasCategory(){
        CategoryListing cl = new CategoryListing();
        cl.updateCategory("History");
        String expected = "History";
        String theCategory = cl.obtainCategoryGenre();
        assertEquals("main.entities.CategoryListing has a main.entities.Category", expected, theCategory);
    }

    @Test
    public void testCategoryListingCategoryHasSubcategories(){
        Category c = new Category("History");
        c.giveSubcategory("USA");
        c.giveSubcategory("China");
        c.giveSubcategory("Japan");
        CategoryListing cl = new CategoryListing(c);
        String[] expected = {"USA", "China", "Japan"};
        String[] categories = cl.obtainCategory().obtainSubcategoriesNames();
        assertArrayEquals("main.entities.CategoryListing has a main.entities.Category with Subcategories", expected, categories);
    }
}

