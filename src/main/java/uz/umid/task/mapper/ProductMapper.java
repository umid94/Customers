package uz.umid.task.mapper;

import org.springframework.stereotype.Component;
import uz.umid.task.dto.ProductDTO;
import uz.umid.task.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper{

    public ProductDTO map(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setPhoto(product.getPhoto());
        return productDTO;
    }

    public List<ProductDTO> map(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product p: products){
            ProductDTO productDTO = map(p);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }
}
