package ma.atos.billing.payment.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessObjectDto {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
}
