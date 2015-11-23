package sad.entities;

public class Subcategory extends Category {
    private Category parentCategory;
    private Category rootCategory;

    public Subcategory() {
    }

    public Subcategory(Category parent, String genre){
        super(genre);
        parentCategory = parent;
        if(parent.getClass().getSimpleName().equals("Subcategory"))
            rootCategory = ((Subcategory)parent).obtainRootParentCategory();
        else
            rootCategory = parent;
    }

    public Category obtainParentCategory(){
        return parentCategory;
    }

    public Category obtainRootParentCategory(){
        return rootCategory;
    }
}
