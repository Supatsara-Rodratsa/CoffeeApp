package space.harbour.CoffeeApp.exception;

public class SubCategoryNotFoundException extends Exception {
    public SubCategoryNotFoundException(String message) {
        super(message);
    }
    public SubCategoryNotFoundException() {
        super("Subcategory not found");
    }
}
