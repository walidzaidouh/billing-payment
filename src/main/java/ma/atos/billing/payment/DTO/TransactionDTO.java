package ma.atos.billing.payment.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Long id;
    private LocalDateTime date;
    private Double montant;
    private String operationType;

    private Long customerId;
    private Long pvId;
    private Long creancierId;

}
