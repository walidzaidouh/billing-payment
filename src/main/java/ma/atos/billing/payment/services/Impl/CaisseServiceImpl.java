package ma.atos.billing.payment.services.Impl;

import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.dto.CaisseCreateDTO;
import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.mappers.CaisseMapper;
import ma.atos.billing.payment.models.Transaction;
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
    public boolean closeRegister(Long id, BigDecimal soldeFin) {

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
    public boolean openRegister(Long id) {

        return caisseRepository.openCaisse(id) > 0;
    }

    @Override
    public CaisseDTO getById(Long id) {

        return caisseMapper.toCaisseDto(caisseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Caisse not found with id : " + id)));
    }

    @Override
    public CaisseDTO save(CaisseCreateDTO dto) {

        Caisse caisse = Caisse.builder()
                .montantDepart(dto.getMontantDepart())
                .solde(dto.getSolde())
                .pdvId(dto.getPdvId())
                .isClosed(false)
                .build();

        Caisse saved = caisseRepository.save(caisse);



        return caisseMapper.toCaisseDto(saved);

    }

    @Override
    public void delete(Long id) {

        caisseRepository.deleteById(id);
    }
}
