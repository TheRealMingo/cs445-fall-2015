package test;

import sad.entities.Category;
import sad.entities.Subcategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubcategoryTests {
    @Test
    public void testSubcategoryHaveGenre(){
        Subcategory sc = new Subcategory(new Category("Test"), "Kids Entertainment");
        String genre = sc.getCategoryGenre();
        assertEquals("main.entities.Subcategory does have genre.", "Kids Entertainment", genre);
    }

    @Test
    public void testSubcategoryMustHaveParentCategory(){
        /*Tests that they not only have the same name, but also have the same memory address (location)*/
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "China");
        Category parentCategory = sc.obtainParentCategory();
        assertEquals("main.entities.Subcategory does have parent category", c, parentCategory);
    }

    @Test
    public void testSubcategoryCanHaveASubcategory(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "China");
        sc.giveSubcategory("Qing Dynasty");
        String[] subcat = sc.obtainSubcategoriesNames();
        assertEquals("main.entities.Subcategory length for one subcategory should be 1", 1, subcat.length);
        assertEquals("main.entities.Subcategory has a subcategory", "Qing Dynasty", subcat[0]);
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
        assertArrayEquals("main.entities.Subcategory have subcategories", expected, subcats);
    }

    @Test
    public void testSubcategoryCanObtainParentCategory(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "China");
        Category parent = sc.obtainParentCategory();
        String parentName = parent.getCategoryGenre();
        assertEquals("main.entities.Subcategory's parent memory location is correct", c, parent);
        assertEquals("main.entities.Subcategory's name is correct", "History", parentName);
    }

    @Test
    public void testSubcategoryCanObtainParentCategoryInAChain(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "Modern");
        Subcategory sc0 = new Subcategory(sc, "2008");
        Subcategory sc1 = new Subcategory(sc0, "Presidential Elections");
        Category sc1Parent = sc1.obtainParentCategory();
        String parentName = sc1Parent.getCategoryGenre();
        assertEquals("main.entities.Subcategory's parent memory location is correct", sc0, sc1Parent);
        assertEquals("main.entities.Subcategory's name is correct", "2008", parentName);
    }

    @Test
    public void testSubcategoryCanObtainRootParentInChain(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "Modern");
        Subcategory sc0 = new Subcategory(sc, "2008");
        Subcategory sc1 = new Subcategory(sc0, "Presidential Elections");
        Category sc1RootParent = sc1.obtainRootParentCategory();
        String rootParentName = sc1RootParent.getCategoryGenre();
        assertEquals("main.entities.Subcategory's root parent memory location is correct", c, sc1RootParent);
        assertEquals("main.entities.Subcategory's root parent name is corret", "History", rootParentName);
    }

    @Test
    public void testSubcategoryCanHaveSubCategories(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "Modern");
        sc.giveSubcategory("USA");
        sc.giveSubcategory("China");
        String[] subcats = sc.obtainSubcategoriesNames();
        String[] expected = {"USA", "China"};
        assertArrayEquals("Subcategory can have subcategory", expected, subcats);
    }

    @Test
    public void testSubcategoriesAreEqual(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "Modern");
        sc.giveSubcategory("USA");
        Subcategory sc1 = new Subcategory(c, "Modern");
        sc1.giveSubcategory("USA");
        assertTrue("Subcategories should be equal", sc.equalsTo(sc1));
    }

    @Test
    public void testSubcategoriesAreNotEqual(){
        Category c = new Category("History");
        Subcategory sc = new Subcategory(c, "Modern");
        sc.giveSubcategory("USA");
        Subcategory sc1 = new Subcategory(c, "Modern");
        sc1.giveSubcategory("China");
        assertFalse("Subcategories should not be equal", sc.equalsTo(sc1));
    }
}

