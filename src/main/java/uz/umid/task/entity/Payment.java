package uz.umid.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment extends BaseEntity{

    @Column(name = "time")
    private Date time;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne()
    @JoinColumn(name="invoice_id", nullable = false)
    private Invoice invoice;

}
