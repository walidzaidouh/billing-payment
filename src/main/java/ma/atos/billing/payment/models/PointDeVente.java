package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class PointDeVente extends BusinessObject {

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADRESSE")
    private String adresse;
}