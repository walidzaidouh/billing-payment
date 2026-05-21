package ma.atos.billing.payment.services;


import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.dto.TransactionCreationDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {


    @Cacheable(value = "transaction", key = "#id")
    TransactionDTO getTransactionByID(Long id);


    BigDecimal getTransactionAmount(Long id);


    @Cacheable(value = "transactionsByCaisse", key = "#caisse.id")
    List<TransactionDTO> getTrasactionByCaisse(Caisse caisse);


    @Cacheable(value = "transactionsByCustomer", key = "#customerId")
    List<TransactionDTO> findByCustomerId(Long customerId);


    @Caching(evict = {
            @CacheEvict(value = "transaction", key = "#result.id", condition = "#result != null"),
            @CacheEvict(value = "transactionsByCaisse", allEntries = true),
            @CacheEvict(value = "transactionsByCustomer", allEntries = true)
    })
    TransactionDTO save(TransactionCreationDTO dto);


    @Caching(evict = {
            @CacheEvict(value = "transaction", key = "#id"),
            @CacheEvict(value = "transactionsByCaisse", allEntries = true),
            @CacheEvict(value = "transactionsByCustomer", allEntries = true)
    })
    void delete(Long id);

    List<TransactionDTO> getAllTransactions();
}
