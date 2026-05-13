package ma.atos.billing.payment.models;


import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;


import org.springframework.data.annotation.LastModifiedDate ;
import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusnessObject {

    @CreatedDate
   private Date createdDate ;

   @LastModifiedDate
   private Date updatedDate ;
}
