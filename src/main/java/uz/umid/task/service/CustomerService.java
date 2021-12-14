package uz.umid.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.umid.task.dto.CustomerDTO;
import uz.umid.task.dto.CustomerLastOrdersResponseDTO;
import uz.umid.task.dto.NumberOfProductsInYearResponseDTO;
import uz.umid.task.mapper.CustomerMapper;
import uz.umid.task.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerLastOrdersResponseDTO> customerLastOrders() {
        List<CustomerLastOrdersResponseDTO> customerDTOS = customerRepository.customerLastOrders();
        return customerDTOS;
    }

    public List<NumberOfProductsInYearResponseDTO> getSumOrdersInYearByCountry() {
        int date1 = 2016;
        List<NumberOfProductsInYearResponseDTO> responseDTOList = customerRepository.getSumOrdersInYearByCountry(date1);
        return responseDTOList;
    }

    public List<CustomerDTO> customersWithoutOrders() {
        int date1 = 2016;
        List<CustomerDTO> customerDtos = customerMapper.map(customerRepository.customersWithoutOrders(date1));
        return customerDtos;
    }
}
