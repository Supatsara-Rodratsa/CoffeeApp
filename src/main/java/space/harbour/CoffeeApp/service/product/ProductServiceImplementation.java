package space.harbour.CoffeeApp.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.harbour.CoffeeApp.domain.Product;
import space.harbour.CoffeeApp.domain.SubCategory;
import space.harbour.CoffeeApp.dto.ProductDTO;
import space.harbour.CoffeeApp.exception.ProductNotFoundException;
import space.harbour.CoffeeApp.exception.SubCategoryNotFoundException;
import space.harbour.CoffeeApp.repository.ProductRepository;
import space.harbour.CoffeeApp.repository.SubCategoryRepository;

import java.util.List;

@Service
public class ProductServiceImplementation  implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsBySubCategory(SubCategory subCategory) {
        return subCategory.getProducts();
    }

    @Override
    public List<Product> getHighlightProduct() {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allHighlightMenu = allProducts.stream().filter(iter -> iter.getIsHighlightMenu()).toList();
        return allHighlightMenu;
    }

    @Override
    public void addProduct(ProductDTO product) throws SubCategoryNotFoundException {
        SubCategory subCategory = subCategoryRepository.findById(product.getSubCategoryId())
                .orElseThrow(SubCategoryNotFoundException::new);
        if (subCategory != null) {
            Product newProduct = new Product();
            modelMapper.map(product, newProduct);
            newProduct.setSubCategory(subCategory);
            productRepository.save(newProduct);
        }
    }

    @Override
    public void removeProduct(long id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }

    @Override
    public void modifyProduct(long id, ProductDTO product) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        modelMapper.map(product, existingProduct);
        existingProduct.setId(id);
        productRepository.save(existingProduct);
    }
}
