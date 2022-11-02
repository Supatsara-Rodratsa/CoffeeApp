package space.harbour.CoffeeApp.service.subcategory;

import org.springframework.stereotype.Service;
import space.harbour.CoffeeApp.domain.SubCategory;
import space.harbour.CoffeeApp.dto.SubCategoryDTO;
import space.harbour.CoffeeApp.exception.CategoryNotFoundException;
import space.harbour.CoffeeApp.exception.SubCategoryNotFoundException;

import java.util.List;

@Service
public interface SubCategoryService {
    List<SubCategory> findAllSubCategories();
    void addSubCategory(SubCategoryDTO subCategory) throws CategoryNotFoundException;

    SubCategory findSubCategoryById(Long id) throws SubCategoryNotFoundException;
}
