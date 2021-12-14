package uz.umid.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity{

    @Column(name = "date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "orders")
    private Invoice invoice;

    @OneToMany(mappedBy = "orders")
    private List<Detail> details;


}
