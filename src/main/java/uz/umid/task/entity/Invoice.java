package uz.umid.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class Invoice extends BaseEntity{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order orders;

    @JoinColumn(name = "amount")
    private BigDecimal amount;

    @JoinColumn(name = "issued")
    private Date issued;

    @JoinColumn(name = "due")
    private Date due;

    @OneToMany(mappedBy = "invoice")
    private List<Payment> payments;

}
