package ma.atos.billing.payment.Repositories;

import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction,Long> {

    List<Transaction> findByCustomerId(Long customerId);

    List<Transaction>getTransactionByDate(Date date);

    List<Transaction>getTransactionByOperationType(OperationType operationType);




}
