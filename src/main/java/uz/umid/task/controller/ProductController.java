package uz.umid.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.umid.task.dto.BulkProductsResponseDTO;
import uz.umid.task.dto.HighDemandProductsResponseIDTO;
import uz.umid.task.dto.ProductDTO;
import uz.umid.task.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v.1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/list")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<ProductDTO> getById(@RequestParam(name = "productId") Long id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/high-demand-products")
    public ResponseEntity<List<HighDemandProductsResponseIDTO>> getHighDemandProducts() {
        return new ResponseEntity<>(productService.getHighDemandProducts(), HttpStatus.OK);
    }

    @GetMapping("/bulk-products")
    public ResponseEntity<List<BulkProductsResponseDTO>> getBulkProducts() {
        return new ResponseEntity<>(productService.getBulkProducts(), HttpStatus.OK);
    }

}
