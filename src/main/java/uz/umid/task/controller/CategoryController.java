package uz.umid.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.umid.task.dto.CategoryDTO;
import uz.umid.task.service.CategoryService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

//
@RestController
@RequestMapping("/api/v.1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/list")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), OK);
    }

    @GetMapping("/category")
    public ResponseEntity<CategoryDTO> getCategoryByProductId(@RequestParam(name = "productId") Long id) {
        return new ResponseEntity<>(categoryService.getByProductId(id), OK);
    }
}
