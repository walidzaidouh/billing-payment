package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.enums.OperationType;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "TRANSACTION", schema = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Transaction extends BusinessObject {

    @Column(name = "MONTANT")
    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATION_TYPE")
    private OperationType operationType;

    @ManyToOne
    @JoinColumn(name = "CAISSE_ID")
    private Caisse caisse;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "PV_ID")
    private Long pvId;

    @Column(name = "CREANCIER_ID")
    private Long creancierId;


}