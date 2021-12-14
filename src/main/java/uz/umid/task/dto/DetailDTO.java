package uz.umid.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.umid.task.entity.Detail;

@Data
@NoArgsConstructor
public class DetailDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private String productName;
}
