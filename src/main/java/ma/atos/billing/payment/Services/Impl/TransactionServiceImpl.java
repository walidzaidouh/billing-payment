package ma.atos.billing.payment.Services.Impl;


import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {


    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransByCustomer(Long customerId) {
        return List.of();
    }

    @Override
    public List<Transaction> getAllTransactionByPV(Long pvId) {
        return List.of();
    }

    @Override
    public List<Transaction> getAllTransactionByCreancier(Long CreancierId) {
        return List.of();
    }
}
