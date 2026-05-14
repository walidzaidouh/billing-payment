package ma.atos.billing.payment.Services;

import ma.atos.billing.payment.models.Caisse;

import java.math.BigDecimal;

public interface CaisseService {

    boolean fermerCaisse (Long id, BigDecimal soldeFin) ;

    boolean ouvrirCaisse(Long id ) ;

    Caisse getById(Long id) ;
}
