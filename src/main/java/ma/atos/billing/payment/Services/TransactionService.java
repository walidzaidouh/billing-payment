package ma.atos.billing.payment.Services;


import ma.atos.billing.payment.models.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    Transaction getTransactionByID()  ;

    List<Transaction> getTransactionByClient(Long id ) ;

    BigDecimal getTransactionAmount(Long id) ;
}
