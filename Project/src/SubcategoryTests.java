import exceptions.CategoryMustHaveGenreException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class SubcategoryTests {
    @Test(expected= CategoryMustHaveGenreException.class)
    public void testSubcategoryMustHaveGenre() throws CategoryMustHaveGenreException {
        Subcategory sc = new Subcategory();
        System.out.println("Subcategory must have genre exception is thrown.");
    }

    @Test
    public void testSubcategoryHaveGenre(){
        Subcategory sc = new Subcategory(new Category("Test"), "Kids Entertainment");
        String genre = sc.obtainGenre();
        assertEquals("Subcategory does have genre.", "Kids Entertainment", genre);
    }

    @Test
    public void testSubcategoryMustHaveParentCategory(){
        /*Tests that they not only have the same name, but also have the same memory address (location)*/
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "China");
        Category parentCategory = sc.obtainParentCategory();
        assertEquals("Subcategory does have parent category", c, parentCategory);
    }

    @Test
    public void testSubcategoryCanHaveASubcategory(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "China");
        sc.giveSubcategory("Qing Dynasty");
        String[] subcat = sc.obtainSubcategoriesNames();
        assertEquals("Subcategory length for one subcategory should be 1", 1, subcat.length);
        assertEquals("Subcategory has a subcategory", "Qing Dynasty", subcat[0]);
    }

    @Test
    public void testSubcategoryCanHaveSubcategories(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "China");
        sc.giveSubcategory("Qing Dynasty");
        sc.giveSubcategory("Han Dynasty");
        sc.giveSubcategory("Zhou Dynasty");
        String[] subcats = sc.obtainSubcategoriesNames();
        String[] expected = {"Qing Dynasty", "Han Dynasty", "Zhou Dynasty"};
        assertArrayEquals("Subcategory have subcategories", expected, subcats);
    }

    @Test
    public void testSubcategoryCanObtainParentCategory(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "China");
        Category parent = sc.obtainParentCategory();
        String parentName = parent.obtainGenre();
        assertEquals("Subcategory's parent memory location is correct", c, parent);
        assertEquals("Subcategory's name is correct", "History", parentName);
    }

    @Test
    public void testSubcategoryCanObtainParentCategoryInAChain(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "Modern");
        Subcategory sc0 = new Subcategory(sc, "2008");
        Subcategory sc1 = new Subcategory(sc0, "Presidential Elections");
        Category sc1Parent = sc1.obtainParentCategory();
        String parentName = sc1Parent.obtainGenre();
        assertEquals("Subcategory's parent memory location is correct", sc0, sc1Parent);
        assertEquals("Subcategory's name is correct", "2008", parentName);
    }

    @Test
    public void testSubcategoryCanObtainRootParentInChain(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "Modern");
        Subcategory sc0 = new Subcategory(sc, "2008");
        Subcategory sc1 = new Subcategory(sc0, "Presidential Elections");
        Category sc1RootParent = sc1.obtainRootParentCategory();
        String rootParentName = sc1RootParent.obtainGenre();
        assertEquals("Subcategory's root parent memory location is correct", c, sc1RootParent);
        assertEquals("Subcategory's root parent name is corret", "History", rootParentName);
    }
}

