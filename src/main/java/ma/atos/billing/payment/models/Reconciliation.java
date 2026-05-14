package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "RECONCILIATION", schema = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reconciliation extends BusinessObject {

    @OneToOne
    @JoinColumn(name = "CAISSE_ID")
    private Caisse caisse;

    @Column(name = "TOTAL_DEBIT")
    private BigDecimal totalDebit;

    @Column(name = "TOTAL_CREDIT")
    private BigDecimal totalCredit;

    @Column(name = "IS_CORRECT")
    private boolean isCorrect;
}
