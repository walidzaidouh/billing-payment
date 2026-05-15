package ma.atos.billing.payment.dto;


import lombok.*;
import ma.atos.billing.payment.enums.OperationType;


import java.math.BigDecimal;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionDTO {


    private Date date;
    private BigDecimal montant;
    private OperationType operationType;
    private CaisseDTO caisse;

}
