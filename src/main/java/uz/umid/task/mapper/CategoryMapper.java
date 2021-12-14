package uz.umid.task.mapper;

import org.springframework.stereotype.Component;
import uz.umid.task.dto.CategoryDTO;
import uz.umid.task.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper  {
    public CategoryDTO map(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public List<CategoryDTO> map(List<Category> categories) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(Category c: categories){
            CategoryDTO categoryDTO = map(c);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }
}

