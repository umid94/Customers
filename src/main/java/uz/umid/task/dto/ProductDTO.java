package uz.umid.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.umid.task.entity.Product;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String photo;
    private Long categoryId;
    private int quantity;

}
