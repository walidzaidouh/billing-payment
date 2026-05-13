package ma.atos.billing.payment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reconciliation extends JpaRepository<Reconciliation,Long> {
}
