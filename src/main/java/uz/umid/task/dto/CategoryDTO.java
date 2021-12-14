package uz.umid.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.umid.task.entity.Category;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
}
