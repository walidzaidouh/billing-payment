package ma.atos.billing.payment.repositories;

import ma.atos.billing.payment.models.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse,Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
            UPDATE Caisse c
            SET c.isClosed = true
            WHERE c.id = :id
            """)
    int closeCaisse(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("""
            UPDATE Caisse c
            SET c.isClosed = false
            WHERE c.id = :id
            """)
    int openCaisse(@Param("id") Long id);

}
