package space.harbour.CoffeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.harbour.CoffeeApp.domain.Category;
import space.harbour.CoffeeApp.dto.ProductDTO;
import space.harbour.CoffeeApp.exception.CategoryNotFoundException;
import space.harbour.CoffeeApp.service.category.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Add to database
    @PostMapping(value = "/categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category); // Map automatically
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAllCategories()).getBody();
    }

}
