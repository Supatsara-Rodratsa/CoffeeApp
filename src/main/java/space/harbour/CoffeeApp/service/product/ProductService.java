package space.harbour.CoffeeApp.service.product;

import org.springframework.stereotype.Service;
import space.harbour.CoffeeApp.domain.Product;
import space.harbour.CoffeeApp.domain.SubCategory;
import space.harbour.CoffeeApp.dto.ProductDTO;
import space.harbour.CoffeeApp.exception.ProductNotFoundException;
import space.harbour.CoffeeApp.exception.SubCategoryNotFoundException;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAllProducts();
    List<Product> getProductsBySubCategory(SubCategory subCategory);

    List<Product> getHighlightProduct();

    void addProduct(ProductDTO product) throws SubCategoryNotFoundException;
    void removeProduct(long id) throws ProductNotFoundException;
    void modifyProduct(long id, ProductDTO product) throws ProductNotFoundException;
}
