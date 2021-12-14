package uz.umid.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.umid.task.dto.CategoryDTO;
import uz.umid.task.mapper.CategoryMapper;
import uz.umid.task.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> getAll() {
        List<CategoryDTO> categoryDTOs = categoryMapper.map(categoryRepository.getAll());
        return categoryDTOs;
    }

    public CategoryDTO getByProductId(Long id) {
        CategoryDTO categoryDTO = categoryMapper.map(categoryRepository.getCategoryByProductId(id));
        return categoryDTO;
    }
}
