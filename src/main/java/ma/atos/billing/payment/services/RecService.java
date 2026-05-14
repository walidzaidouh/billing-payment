package ma.atos.billing.payment.services;

import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;

import java.math.BigDecimal;

public interface RecService {


    Reconciliation executeStlm(Caisse caisse, BigDecimal soldeFin);
}
