package space.harbour.CoffeeApp.exception;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String message) {
        super(message);
    }
    public CategoryNotFoundException() {
        super("Category not found");
    }
}
