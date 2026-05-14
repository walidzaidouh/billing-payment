package ma.atos.billing.payment.Services.Impl;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.Repositories.TransactionRepository;
import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Customer;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction getTransactionByID(Long id) {

        return transactionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Transaction not found with id : " + id));
    }

    @Override
    public List<Transaction> getTransactionByClient(Customer customer) {

        return transactionRepository.findByCustomer(customer);
    }

    @Override
    public BigDecimal getTransactionAmount(Long id) {

        Transaction transaction = getTransactionByID(id);

        return transaction.getMontant();
    }

    @Override
    public List<Transaction> getTrasactionByCaisse(Caisse caisse) {

        return transactionRepository.findByCaissesContaining(caisse);
    }

    @Override
    public Transaction save(Transaction transaction) {

        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {

        transactionRepository.deleteById(id);
    }
}