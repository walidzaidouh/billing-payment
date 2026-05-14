package ma.atos.billing.payment.Services;


import ma.atos.billing.payment.models.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    List<Transaction> getAllTransByCustomer(Long customerId);

    List<Transaction> getAllTransactionByPV( Long pvId);

    List<Transaction> getAllTransactionByCreancier( Long CreancierId);

}
