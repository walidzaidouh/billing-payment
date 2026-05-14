package ma.atos.billing.payment.Repositories;

import ma.atos.billing.payment.models.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse,Long> {

    Caisse findById(Long id ) ;

    Caisse save (Caisse s ) ;
}
