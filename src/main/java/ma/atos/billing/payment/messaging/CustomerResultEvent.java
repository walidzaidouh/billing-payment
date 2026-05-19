package ma.atos.billing.payment.messaging;

import ma.atos.billing.payment.enums.PaymentType;

public record CustomerResultEvent(

          Long id,
          String prenom,
          String nom,
          String adresse,
          PaymentType paymentType
) {
}
