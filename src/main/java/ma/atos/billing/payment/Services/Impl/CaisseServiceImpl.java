package ma.atos.billing.payment.Services.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.Repositories.CaisseRepository;
import ma.atos.billing.payment.Services.CaisseService;
import ma.atos.billing.payment.Services.RecService;
import ma.atos.billing.payment.models.Caisse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Service
@Data
public class CaisseServiceImpl implements CaisseService {

    private CaisseRepository caisseRepository ;
    private RecService recService ;

    @Override
    public boolean fermerCaisse(Long id, BigDecimal soldeFin) {
       boolean output =  caisseRepository.closeCaisse(id)>0;
        Caisse caisse = caisseRepository.findById(id).get() ;
       if (output){
           recService.executeStlm(caisse,soldeFin) ;
       }
       return output ;
    }

    @Override
    public boolean ouvrirCaisse(Long id) {
        return caisseRepository.openCaisse(id)>0;
    }

    @Override
    public Caisse getById(Long id) {
        return caisseRepository.findById(id).get();
    }
}
