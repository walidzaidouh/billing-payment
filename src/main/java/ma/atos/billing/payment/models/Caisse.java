package ma.atos.billing.payment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
public class Caisse extends BusnessObject {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id  ;

    @Column(name = "DATE")
    private Date date ;

    private BigDecimal montantDepart ;

    private BigDecimal Solde ;

    @ManyToOne
    private PointDeVente pdv ; // a verifier

    @OneToMany
    private List<Transaction> transactions ;

    @OneToOne
    private Reconciliation reconciliation ;



}
