package space.harbour.CoffeeApp.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String details;
    @Column
    private float price;
    @Column
    @Lob
    private String image;
    @Column
    private Boolean isHighlightMenu;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;
}
