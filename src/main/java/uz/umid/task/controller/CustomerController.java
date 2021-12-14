package uz.umid.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.umid.task.dto.CustomerDTO;
import uz.umid.task.dto.CustomerLastOrdersResponseDTO;
import uz.umid.task.dto.NumberOfProductsInYearResponseDTO;
import uz.umid.task.service.CustomerService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v.1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers-without-order")
    public ResponseEntity<List<CustomerDTO>> customersWithoutOrders() {
        return new ResponseEntity<>(customerService.customersWithoutOrders(), OK);
    }

    @GetMapping("/customers-last-order")
    public ResponseEntity<List<CustomerLastOrdersResponseDTO>> customerLastOrders() {
        return new ResponseEntity<>(customerService.customerLastOrders(), OK);
    }

    @GetMapping("/number-of-products-in-year")
    public ResponseEntity<List<NumberOfProductsInYearResponseDTO>> getSumOrdersInYearByCountry() {
        return new ResponseEntity<>(customerService.getSumOrdersInYearByCountry(), OK);
    }
}
