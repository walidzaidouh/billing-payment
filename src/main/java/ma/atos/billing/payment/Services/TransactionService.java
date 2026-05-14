package ma.atos.billing.payment.Services;


import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Customer;
import ma.atos.billing.payment.models.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    Transaction getTransactionByID(Long id )  ;

    List<Transaction> getTransactionByClient(Customer customer ) ;

    BigDecimal getTransactionAmount(Long id) ;


    List<Transaction> getTrasactionByCaisse(Caisse caisse ) ;
}
