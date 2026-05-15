package ma.atos.billing.payment.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.CreatedDate;


import org.springframework.data.annotation.LastModifiedDate ;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class BusinessObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQUENCE")
    @SequenceGenerator(
            name = "GLOBAL_SEQUENCE",
            sequenceName = "GLOBAL_SEQUENCE",
            allocationSize = 1
    )
    @Column(name = "ID")
    private Long id;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private java.sql.Date createdDate;

    @LastModifiedDate
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
}