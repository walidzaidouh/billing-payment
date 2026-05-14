package ma.atos.billing.payment.Repositories;

import ma.atos.billing.payment.models.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaisseRepository extends JpaRepository<Caisse,Long> {
}
