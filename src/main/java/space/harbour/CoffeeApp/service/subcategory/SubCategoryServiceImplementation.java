package space.harbour.CoffeeApp.service.subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.harbour.CoffeeApp.domain.Category;
import space.harbour.CoffeeApp.domain.Product;
import space.harbour.CoffeeApp.domain.SubCategory;
import space.harbour.CoffeeApp.dto.SubCategoryDTO;
import space.harbour.CoffeeApp.exception.CategoryNotFoundException;
import space.harbour.CoffeeApp.exception.SubCategoryNotFoundException;
import space.harbour.CoffeeApp.repository.CategoryRepository;
import space.harbour.CoffeeApp.repository.SubCategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImplementation implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<SubCategory> findAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public void addSubCategory(SubCategoryDTO subCategory) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(subCategory.getCategoryId())
                .orElseThrow(CategoryNotFoundException::new);
        if (category != null) {
            SubCategory newSubCategory = new SubCategory();
            newSubCategory.setCategory(category);
            newSubCategory.setName(subCategory.getName());
            subCategoryRepository.save(newSubCategory);
        }
    }

    @Override
    public SubCategory findSubCategoryById(Long id) throws SubCategoryNotFoundException {
        return subCategoryRepository.findById(id)
                .orElseThrow(SubCategoryNotFoundException::new);
    }
}
