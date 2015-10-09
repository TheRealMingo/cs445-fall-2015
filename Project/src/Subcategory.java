import exceptions.SubCategoryMustHaveGenreException;

public class Subcategory {
    public String subcategoryGenre;
  /*Subcategory can have a subcategory*/
    public Subcategory() throws SubCategoryMustHaveGenreException {
        throw new SubCategoryMustHaveGenreException();
    }

    public Subcategory(String genre){
        subcategoryGenre = genre;
    }

    public String obtainGenre(){
        return subcategoryGenre;
    }
}
