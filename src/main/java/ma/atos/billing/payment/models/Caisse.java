package ma.atos.billing.payment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Id
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Caisse {

    private Long id  ;
    private Date date ;
}
