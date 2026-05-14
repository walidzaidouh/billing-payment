package ma.atos.billing.payment.Services;

import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;

import java.math.BigDecimal;

public interface RecService {


    Reconciliation executeStlm(Caisse caisse, BigDecimal soldeFin);
}
