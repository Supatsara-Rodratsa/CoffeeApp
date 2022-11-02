package space.harbour.CoffeeApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import space.harbour.CoffeeApp.domain.SubCategory;

import java.util.List;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
    List<SubCategory> findAll();
}
