package uz.umid.task.mapper;

import org.springframework.stereotype.Component;
import uz.umid.task.dto.CustomerDTO;
import uz.umid.task.entity.Customer;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    public CustomerDTO map(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setCountry(customer.getCountry());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAdress());
        return customerDTO;
    }

    public List<CustomerDTO> map(List<Customer> customers) {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer c: customers){
            CustomerDTO customerDTO = map(c);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
