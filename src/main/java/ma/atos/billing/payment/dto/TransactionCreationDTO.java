package ma.atos.billing.payment.dto;

import lombok.Data;
import ma.atos.billing.payment.enums.OperationType;

import java.math.BigDecimal;

@Data
public class TransactionCreationDTO {

    private BigDecimal montant;
    private OperationType operationType;

    private Long caisseId;     // instead of full object
    private Long customerId;

    private Long pvId;
    private Long creancierId;
}

