package uz.umid.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumberOfProductsInYearResponseDTO {
    String countryName;
    Long count;

}
