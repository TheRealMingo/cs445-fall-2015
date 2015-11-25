package sad.entities;

public class CategoryArray {
    private Category[] theCategories = new Category[100];
    private int num_of_categories = 0;
    private int theCategoryIndex = 0;

    private void increaseCapacity(){
        Category[] temp = new Category[num_of_categories + 100];
        for(int i = 0; i < num_of_categories; i++){
            temp[i] = theCategories[i];
        }
        theCategories = temp;
    }

    public void addCategory(Category category){
        if(theCategoryIndex == num_of_categories){
            increaseCapacity();
        }
        theCategories[theCategoryIndex++] = category;
        ++num_of_categories;
    }

    public int getTotalNumOfCategories(){
        return num_of_categories;
    }

    public Category getCategory(int pos){
        if(pos >= 0 && pos <= num_of_categories){
            return theCategories[pos];
        }
        else{
            return null;
        }
    }

    public Category[] obtainAllCategories(){
        Category[] temp = new Category[theCategoryIndex];
        for(int i = 0; i < theCategoryIndex; i++){
            temp[i] = theCategories[i];
        }
        return temp;
    }

    public void removeCategoryAtPos(int pos){
        Category[] temp = new Category[--theCategoryIndex];
        int count = 0;
        for(int i = 0; i < theCategoryIndex+1; i++){
            if(pos != i) {
                temp[count++] = theCategories[i];
            }
        }
        theCategories = temp;
    }
}
