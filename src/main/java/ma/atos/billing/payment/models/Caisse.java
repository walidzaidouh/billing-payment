package ma.atos.billing.payment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "CAISSE", schema = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Caisse extends BusinessObject {

    @Column(name = "DATE")
    private Date date;

    @Column(name = "MONTANT_DEPART")
    private BigDecimal montantDepart;

    @Column(name = "SOLDE")
    private BigDecimal solde;

    @Column(name = "PDV_ID")
    private Long pdvId;

    @Column(name = "IS_CLOSED")
    private boolean isClosed;

    @OneToMany
    @JoinTable(
            name = "CAISSE_TRANSACTIONS",
            schema = "payment",
            joinColumns = @JoinColumn(name = "CAISSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRANSACTION_ID")
    )
    private List<Transaction> transactions;

    @OneToOne
    @JoinColumn(name = "RECONCILIATION_ID")
    private Reconciliation reconciliation;
}