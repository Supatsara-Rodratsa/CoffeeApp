package space.harbour.CoffeeApp.service.category;

import org.springframework.stereotype.Service;
import space.harbour.CoffeeApp.domain.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAllCategories();
    void addCategory(Category category);
}
