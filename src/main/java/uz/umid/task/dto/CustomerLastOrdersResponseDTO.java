package uz.umid.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CustomerLastOrdersResponseDTO {
    Long id;
    String name;
    Date lastDate;
}
