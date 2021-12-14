package uz.umid.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.umid.task.entity.Customer;

import java.util.Date;

@Data
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String country;
    private String address;
    private String phone;
    private Date lastDate;
}
