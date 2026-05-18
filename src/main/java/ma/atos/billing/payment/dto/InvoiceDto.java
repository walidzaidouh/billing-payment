package ma.atos.billing.payment.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.enums.PaymentType;
import ma.atos.billing.payment.enums.StatusInvoice;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;

    @NotBlank
    private String reference;

    private LocalDate dateInvoice;

    private LocalDate dateDue;

    @PositiveOrZero
    private Double montantHt;

    @PositiveOrZero
    private Double montantTva;

    @PositiveOrZero
    private Double montantTtc;

    private StatusInvoice status;

    private PaymentType modeReglement;

    private String description;

    // Relations -> IDs (évite les boucles JSON et dépendances JPA)
    @NotNull
    private Long customerId;

    @NotNull
    private Long creancierId;

    @NotNull
    private Long pointDeVenteId;

    private Date createdDate;

    private Date updatedDate;
}

