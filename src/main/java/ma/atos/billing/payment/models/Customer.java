package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.enums.PaymentType;

import java.util.List;


@Entity
@Table(name = "CUSTOMER", schema = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer extends BusinessObject {

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "ADRESSE")
    private String adresse;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;

    @OneToMany
    @JoinTable(
            name = "CUSTOMER_TRANSACTIONS",
            schema = "payment",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRANSACTION_ID")
    )
    private List<Transaction> transactions;
}
