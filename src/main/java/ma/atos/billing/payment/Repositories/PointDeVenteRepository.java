package ma.atos.billing.payment.Repositories;

import ma.atos.billing.payment.models.PointDeVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointDeVenteRepository extends JpaRepository<PointDeVente, Long> {
}
