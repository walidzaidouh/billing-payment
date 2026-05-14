package ma.atos.billing.payment.services;

import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.models.Caisse;

import java.math.BigDecimal;

public interface CaisseService {

    boolean fermerCaisse (Long id, BigDecimal soldeFin) ;

    boolean ouvrirCaisse(Long id ) ;

    CaisseDTO getById(Long id) ;

    CaisseDTO save(Caisse caisse);

    void delete(Long id);
}
