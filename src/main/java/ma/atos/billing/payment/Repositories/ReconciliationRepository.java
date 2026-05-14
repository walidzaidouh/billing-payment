package ma.atos.billing.payment.Repositories;



import ma.atos.billing.payment.models.Reconciliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReconciliationRepository extends JpaRepository<Reconciliation, Long> {


}