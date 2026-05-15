package ma.atos.billing.payment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CaisseCreateDTO {

    private BigDecimal montantDepart;
    private BigDecimal solde;
    private Long pdvId;
}