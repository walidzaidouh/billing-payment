package ma.atos.billing.payment.services;

import ma.atos.billing.payment.dto.CaisseCreateDTO;
import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.models.Caisse;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.math.BigDecimal;
import java.util.List;

public interface CaisseService {

    boolean closeRegister(Long id, BigDecimal soldeFin) ;


    boolean openRegister(Long id ) ;

    @Cacheable(value = "caisses")
    List<CaisseDTO> getAll();

    @Cacheable(value = "caisse", key = "#id")
    CaisseDTO getById(Long id) ;

    @CacheEvict(value = "caisses", allEntries = true)
    CaisseDTO save(CaisseCreateDTO caisse);

    @CacheEvict(value = "caisses", allEntries = true)
    void delete(Long id);
}
