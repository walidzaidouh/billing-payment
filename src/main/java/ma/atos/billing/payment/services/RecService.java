package ma.atos.billing.payment.services;

import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.dto.ReconciliationDTO;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;

import java.math.BigDecimal;

public interface RecService {


    ReconciliationDTO executeStlm(CaisseDTO caisse, BigDecimal soldeFin);
}
