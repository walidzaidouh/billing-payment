package ma.atos.billing.payment.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CaisseDTO {

    private Long id;

    private LocalDateTime date;

    private BigDecimal montantDepart;
    private BigDecimal solde;
    private Long pdvId;

    private boolean closed;

    private List<TransactionDTO> transactions;

    private Long reconciliationId;

}
