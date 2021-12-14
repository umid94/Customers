package uz.umid.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer extends BaseEntity{

    @Column(name = "name", length = 14, nullable = false)
    private String name;

    @Column(name = "country", length = 3, nullable = false)
    private String country;

    @Column(name = "adress")
    private String adress;

    @Column(name = "phone", length = 50)
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
