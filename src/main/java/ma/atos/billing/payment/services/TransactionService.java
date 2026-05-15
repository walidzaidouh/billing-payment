package ma.atos.billing.payment.services;


import ma.atos.billing.payment.dto.TransactionCreationDTO;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Customer;
import ma.atos.billing.payment.models.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    TransactionDTO getTransactionByID(Long id )  ;


    BigDecimal getTransactionAmount(Long id) ;


    List<TransactionDTO> getTrasactionByCaisse(Caisse caisse ) ;
    TransactionDTO save(TransactionCreationDTO dto);

    void delete(Long id);


    List<TransactionDTO> findByCustomerId(Long customerId);
}
