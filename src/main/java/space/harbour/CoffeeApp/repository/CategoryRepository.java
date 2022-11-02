package space.harbour.CoffeeApp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import space.harbour.CoffeeApp.domain.Category;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
