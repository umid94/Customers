package uz.umid.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.umid.task.dto.BulkProductsResponseDTO;
import uz.umid.task.dto.HighDemandProductsResponseIDTO;
import uz.umid.task.dto.ProductDTO;
import uz.umid.task.mapper.ProductMapper;
import uz.umid.task.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> productDTOs = productMapper.map(productRepository.getAllProduct());
        return productDTOs;
    }

    public ProductDTO getById(Long id) {
        ProductDTO productDTO = productMapper.map(productRepository.getById(id));
        return productDTO;
    }

    public List<HighDemandProductsResponseIDTO> getHighDemandProducts() {
        List<HighDemandProductsResponseIDTO> productDTOs = productRepository.getHighDemandProducts();
        return productDTOs;
    }

    public List<BulkProductsResponseDTO> getBulkProducts() {
        List<BulkProductsResponseDTO> productsResponseDTOs = productRepository.getBulkProducts();
        return productsResponseDTOs;
    }
}
