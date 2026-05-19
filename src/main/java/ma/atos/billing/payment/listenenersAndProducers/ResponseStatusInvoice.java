package ma.atos.billing.payment.listenenersAndProducers;

import ma.atos.billing.payment.enums.StatusInvoice;

public record ResponseStatusInvoice (Long invoiceId,Long id, StatusInvoice statusInvoice){}
