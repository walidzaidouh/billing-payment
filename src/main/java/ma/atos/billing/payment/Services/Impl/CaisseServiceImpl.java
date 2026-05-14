package ma.atos.billing.payment.Services.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.Repositories.CaisseRepository;
import ma.atos.billing.payment.Services.CaisseService;
import ma.atos.billing.payment.Services.RecService;
import ma.atos.billing.payment.models.Caisse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class CaisseServiceImpl implements CaisseService {

    private final CaisseRepository caisseRepository;
    private final RecService recService;

    @Override
    public boolean fermerCaisse(Long id, BigDecimal soldeFin) {

        Caisse caisse = caisseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Caisse not found with id : " + id));

        boolean output = caisseRepository.closeCaisse(id) > 0;

        if (output) {
            recService.executeStlm(caisse, soldeFin);
        }

        return output;
    }

    @Override
    public boolean ouvrirCaisse(Long id) {

        return caisseRepository.openCaisse(id) > 0;
    }

    @Override
    public Caisse getById(Long id) {

        return caisseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Caisse not found with id : " + id));
    }

    @Override
    public Caisse save(Caisse caisse) {

        return caisseRepository.save(caisse);
    }

    @Override
    public void delete(Long id) {

        caisseRepository.deleteById(id);
    }
}
