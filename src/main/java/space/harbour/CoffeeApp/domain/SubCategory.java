package space.harbour.CoffeeApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "subcategories")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "subCategory")
    private List<Product> products;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
