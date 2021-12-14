package uz.umid.task.mapper;

import org.springframework.stereotype.Component;
import uz.umid.task.dto.DetailDTO;
import uz.umid.task.entity.Detail;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailMapper {

    public DetailDTO map(Detail detail) {
        DetailDTO detailDTO = new DetailDTO();
        detailDTO.setId(detail.getId());
        detailDTO.setQuantity(detail.getQuantity());
        detailDTO.setOrderId(detail.getOrders().getId());
        detailDTO.setProductId(detail.getProduct().getId());
        return detailDTO;
    }

    public List<DetailDTO> map(List<Detail> details) {
        List<DetailDTO> detailDTOs = new ArrayList<>();
        for(Detail d: details){
            DetailDTO detailDTO = map(d);
            detailDTOs.add(detailDTO);
        }
        return detailDTOs;
    }
}
