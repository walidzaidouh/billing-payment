package ma.atos.billing.payment.messaging;


import ma.atos.billing.payment.enums.OperationType;

import java.math.BigDecimal;

public record PaymentRequestEvent (
        Long transactionId ,
        BigDecimal montant,
        Long operationType,
        OperationType caisseId,
        Long pdvId

){}




