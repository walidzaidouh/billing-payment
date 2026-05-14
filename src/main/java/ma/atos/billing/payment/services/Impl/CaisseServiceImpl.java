package ma.atos.billing.payment.services.Impl;

import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.mappers.CaisseMapper;
import ma.atos.billing.payment.repositories.CaisseRepository;
import ma.atos.billing.payment.services.CaisseService;
import ma.atos.billing.payment.services.RecService;
import ma.atos.billing.payment.models.Caisse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class CaisseServiceImpl implements CaisseService {

    private final CaisseRepository caisseRepository;
    private final RecService recService;
    private final CaisseMapper caisseMapper;

    @Override
    public boolean fermerCaisse(Long id, BigDecimal soldeFin) {

        CaisseDTO caisse = caisseMapper.toCaisseDto(caisseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Caisse not found with id : " + id)));

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
    public CaisseDTO getById(Long id) {

        return caisseMapper.toCaisseDto(caisseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Caisse not found with id : " + id)));
    }

    @Override
    public CaisseDTO save(Caisse caisse) {

        return caisseMapper.toCaisseDto(caisseRepository.save(caisse));
    }

    @Override
    public void delete(Long id) {

        caisseRepository.deleteById(id);
    }
}
