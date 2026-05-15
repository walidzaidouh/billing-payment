package ma.atos.billing.payment.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessObjectDto {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
