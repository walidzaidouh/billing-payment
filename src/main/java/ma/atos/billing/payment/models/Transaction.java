package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.enums.OperationType;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION", schema = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Transaction extends BusinessObject {

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "MONTANT")
    private Double montant;

    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATION_TYPE")
    private OperationType operationType;

    @OneToOne
    private Customer customer;

    private Long pvId;
    private Long creancierId;
}