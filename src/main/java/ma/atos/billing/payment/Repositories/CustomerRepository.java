package ma.atos.billing.payment.Repositories;

import ma.atos.billing.payment.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
