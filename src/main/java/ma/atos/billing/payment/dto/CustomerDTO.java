package ma.atos.billing.payment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.enums.PaymentType;



import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class CustomerDTO {

    private Long id;
    private String prenom;
    private String nom;
    private String adresse;
    private PaymentType paymentType;
    private List<TransactionDTO> transactions;
}

