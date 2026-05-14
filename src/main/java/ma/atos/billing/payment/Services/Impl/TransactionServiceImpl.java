package ma.atos.billing.payment.Services.Impl;


import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.Repositories.CustomerRepository;
import ma.atos.billing.payment.Repositories.TransactionRepository;
import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.models.Customer;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final CustomerRepository customerRepository;


    @Override
    public Transaction createTransaction(Transaction transaction,Long customerId) {

        transaction.setDate(LocalDateTime.now());

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (transaction.getMontant() == null || transaction.getMontant() <= 0) {
            throw new RuntimeException("Montant invalide");
        }

        if (transaction.getOperationType() == null) {
            throw new RuntimeException("Operation type is required");
        }

        transaction.setCustomer(customer);
        return transactionRepository.save(transaction);
    }


    @Override
    public List<Transaction> getAllTransactionByPV(Long pvId) {
        return transactionRepository.findByPvId(pvId);
    }

    @Override
    public List<Transaction> getAllTransactionByCreancier(Long CreancierId) {
        return transactionRepository.findByCreancierId(CreancierId);
    }

    @Override
    public List<Transaction> getAllTransByCustomer(Long customerId) {
        return transactionRepository.findByCustomerId(customerId);
    }
}
