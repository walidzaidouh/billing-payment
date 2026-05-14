package ma.atos.billing.payment.services;


import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Customer;
import ma.atos.billing.payment.models.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    Transaction getTransactionByID(Long id )  ;


    BigDecimal getTransactionAmount(Long id) ;


    List<Transaction> getTrasactionByCaisse(Caisse caisse ) ;
    Transaction save(Transaction transaction);

    void delete(Long id);


    List<Transaction> findByCustomerId(Long customerId);
}
