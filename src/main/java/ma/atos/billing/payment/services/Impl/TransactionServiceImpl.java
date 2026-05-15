package ma.atos.billing.payment.services.Impl;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.mappers.TransactionMapper;
import ma.atos.billing.payment.repositories.TransactionRepository;
import ma.atos.billing.payment.services.TransactionService;
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
    private final TransactionMapper transactionMapper;
    @Override
    public TransactionDTO getTransactionByID(Long id) {

        return transactionMapper.toDto(transactionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Transaction not found with id : " + id)));
    }


    @Override
    public BigDecimal getTransactionAmount(Long id) {

        TransactionDTO transaction = getTransactionByID(id);

        return transaction.getMontant();
    }

    @Override
    public List<TransactionDTO> getTrasactionByCaisse(Caisse caisse) {

        List<Transaction> transactions = transactionRepository.findByCaisse(caisse);

        return transactionMapper.toDtoList(transactions);


    }

    @Override
    public TransactionDTO save(Transaction transaction) {

        return transactionMapper.toDto(transactionRepository.save(transaction));
    }

    @Override
    public void delete(Long id) {

        transactionRepository.deleteById(id);
    }

    @Override
    public List<TransactionDTO> findByCustomerId(Long customerId) {
        return transactionMapper.toDtoList(transactionRepository.findByCustomerId(customerId));
    }
}