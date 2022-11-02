package space.harbour.CoffeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.harbour.CoffeeApp.domain.Category;
import space.harbour.CoffeeApp.domain.SubCategory;
import space.harbour.CoffeeApp.dto.SubCategoryDTO;
import space.harbour.CoffeeApp.exception.CategoryNotFoundException;
import space.harbour.CoffeeApp.service.category.CategoryService;
import space.harbour.CoffeeApp.service.subcategory.SubCategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    // Add to database
    @PostMapping(value = "/subcategories")
    public ResponseEntity<SubCategoryDTO> addSubCategory(@RequestBody SubCategoryDTO subCategory) throws CategoryNotFoundException {
        subCategoryService.addSubCategory(subCategory); // Map automatically
        return new ResponseEntity<>(subCategory, HttpStatus.CREATED);
    }

    @GetMapping("/subcategories")
    public List<SubCategory> getAllSubCategories() {
        return  ResponseEntity.ok(subCategoryService.findAllSubCategories()).getBody();
    }

}
