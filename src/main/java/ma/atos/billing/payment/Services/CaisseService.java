package ma.atos.billing.payment.Services;

import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.Repositories.CaisseRepository;
import ma.atos.billing.payment.Services.Imp.CaisseServiceImp;
import ma.atos.billing.payment.models.Caisse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaisseService implements CaisseServiceImp {

    private final CaisseRepository caisseRepository;

    @Override
    public Caisse createCaisse(Caisse caisse) {
        return caisseRepository.save(caisse);
    }

    @Override
    public Caisse updateCaisse(Caisse caisse) {
        return null;
    }

    @Override
    public Caisse deleteCaisse() {
        return null;
    }

    @Override
    public boolean caisseValide() {
        return false;
    }
}
