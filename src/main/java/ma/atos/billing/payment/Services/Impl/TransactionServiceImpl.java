package ma.atos.billing.payment.Services.Impl;


import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {


    @Override
    public Transaction getTransactionByID() {
        return null;
    }

    @Override
    public List<Transaction> getTransactionByClient(Long id) {
        return List.of();
    }

    @Override
    public BigDecimal getTransactionAmount(Long id) {
        return null;
    }
}
