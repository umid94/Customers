package uz.umid.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "description", length = 20)
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "photo", length = 1024)
    private String photo;

    @OneToMany(mappedBy = "product")
    private List<Detail> details;

}
