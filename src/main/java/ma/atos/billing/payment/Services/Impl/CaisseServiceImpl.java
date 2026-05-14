package ma.atos.billing.payment.Services.Impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.Repositories.CaisseRepository;
import ma.atos.billing.payment.Services.CaisseService;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class CaisseServiceImpl implements CaisseService {

    private CaisseRepository caisseRepository ;


    @Override
    public boolean fermerCaisse(Long id) {
        return false;
    }

    @Override
    public boolean ouvrirCaisse(Long id) {
        return false;
    }
}
