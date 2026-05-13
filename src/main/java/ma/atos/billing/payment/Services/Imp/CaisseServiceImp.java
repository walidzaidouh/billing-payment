package ma.atos.billing.payment.Services.Imp;

import ma.atos.billing.payment.models.Caisse;

public interface CaisseServiceImp {

    public Caisse createCaisse(Caisse caisse);

    public Caisse updateCaisse(Caisse caisse);

    public Caisse deleteCaisse();

    public boolean caisseValide();
}
