package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.enums.PaymentType;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer extends BusnessObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "param_generator")
    private Long id ;

    @Column(name = "PRENOM")
    private String prenom ;

    private String nom  ;

    private String adresse ;

    private PaymentType paymentType ;

    @OneToMany
    private List<Transaction> transactions  ;
}
