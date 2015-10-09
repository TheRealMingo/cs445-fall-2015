import exceptions.SubCategoryMustHaveGenreException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SubcategoryTests {
    @Test(expected= SubCategoryMustHaveGenreException.class)
    public void testSubcategoryMustHaveGenre() throws SubCategoryMustHaveGenreException{
        Subcategory sc = new Subcategory();
        System.out.println("Subcategory must have genre exception is thrown.");
    }

    @Test
    public void testSubcategoryHaveGenre(){
        Subcategory sc = new Subcategory("Kids Entertainment");
        String genre = sc.obtainGenre();
        assertEquals("Subcategory does have genre.", "Kids Entertainment", genre);
    }

    @Test
    public void testSubcategoryCanHaveAnArraySubcategory(){
        //TODO: Write Body
    }


}

