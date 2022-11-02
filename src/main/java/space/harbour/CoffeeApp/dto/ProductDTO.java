package space.harbour.CoffeeApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String details;
    private float price;
    private String image;
    private Long subCategoryId;
    private Boolean isHighlightMenu;
}
