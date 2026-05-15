package ma.atos.billing.payment.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.models.Caisse;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ReconciliationDTO {

    private Long id;

    private CaisseDTO caisse;

    private BigDecimal totalDebit;
    private BigDecimal totalCredit;

    private boolean isCorrect;
}

