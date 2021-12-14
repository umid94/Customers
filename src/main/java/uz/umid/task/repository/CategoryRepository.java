package uz.umid.task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.umid.task.dto.CategoryDTO;
import uz.umid.task.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c")
    List<Category> getAll();

    @Query(value = "SELECT c.category FROM Product c WHERE c.id=?1")
    Category getCategoryByProductId(Long id);
}
