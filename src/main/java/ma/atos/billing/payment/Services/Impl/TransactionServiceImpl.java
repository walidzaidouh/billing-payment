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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository ;


    @Override
    public Transaction getTransactionByID(Long id ) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public List<Transaction> getTransactionByClient(Customer customer) {
        return List.of();
    }



    @Override
    public BigDecimal getTransactionAmount(Long id) {
        return null;
    }

    @Override
    public List<Transaction> getTrasactionByCaisse(Caisse caisse) {
        return List.of();
    }
}
