package ma.atos.billing.payment.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.math.BigDecimal;

=======
>>>>>>> master
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reconciliation extends BusnessObject {

    @OneToOne
    private Caisse caisse ;

    private BigDecimal totalDebit ;

    private BigDecimal totalCredit ;

    private boolean isCorrect ;
}
