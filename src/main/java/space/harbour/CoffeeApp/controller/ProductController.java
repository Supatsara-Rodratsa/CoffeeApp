package space.harbour.CoffeeApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import space.harbour.CoffeeApp.domain.Product;
import space.harbour.CoffeeApp.domain.SubCategory;
import space.harbour.CoffeeApp.dto.ProductDTO;
import space.harbour.CoffeeApp.exception.ProductNotFoundException;
import space.harbour.CoffeeApp.exception.SubCategoryNotFoundException;
import space.harbour.CoffeeApp.service.product.ProductService;
import space.harbour.CoffeeApp.service.subcategory.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SubCategoryService subCategoryService;

    // Add to database
    @PostMapping(value = "/products")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) throws SubCategoryNotFoundException {
        productService.addProduct(product); // Map automatically
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok(products).getBody();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) throws ProductNotFoundException {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDTO product, @PathVariable long id) throws ProductNotFoundException {
        productService.modifyProduct(id, product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/products/{subCategoryId}/products")
    public ResponseEntity<List<Product>> getProductsBySubcategoryId(@PathVariable long subCategoryId) throws SubCategoryNotFoundException {
        SubCategory subCategory = subCategoryService.findSubCategoryById(subCategoryId);
        return new ResponseEntity<>(productService.getProductsBySubCategory(subCategory), HttpStatus.OK);
    }

    @GetMapping("/products/highlight-menu")
    public List<Product> getAllHighlightProducts() {
        List<Product> products = productService.getHighlightProduct();
        return ResponseEntity.ok(products).getBody();
    }
}
