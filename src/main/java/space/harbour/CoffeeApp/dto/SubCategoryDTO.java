package space.harbour.CoffeeApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDTO {
    private String name;
    private Long categoryId;
}
