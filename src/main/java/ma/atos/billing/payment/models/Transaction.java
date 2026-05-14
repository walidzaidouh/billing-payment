package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.enums.OperationType;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Transaction extends BusnessObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "")
    @Column(name = "ID")
    private Long id  ;
    @Column(name = "DATE")
    private Date date ;

    private Double montant  ;

    private OperationType operationType ;

    @OneToOne
    private Caisse caisse;
}
