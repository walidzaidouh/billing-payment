package ma.atos.billing.payment.services.Impl;


import lombok.AllArgsConstructor;
import ma.atos.billing.payment.dto.InvoiceDto;
import ma.atos.billing.payment.dto.TransactionCreationDTO;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.enums.ModeReglement;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.enums.PaymentType;
import ma.atos.billing.payment.enums.StatusInvoice;
import ma.atos.billing.payment.mappers.TransactionMapper;
import ma.atos.billing.payment.proxies.InvoiceExternalProxy;
import ma.atos.billing.payment.repositories.CaisseRepository;
import ma.atos.billing.payment.repositories.TransactionRepository;
import ma.atos.billing.payment.services.TransactionService;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final CaisseRepository caisseRepository;
    public final InvoiceExternalProxy invoiceExternalProxy;




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
    public TransactionDTO save(TransactionCreationDTO dto) {

        Caisse caisse = caisseRepository.findById(dto.getCaisseId())
                .orElseThrow(() -> new RuntimeException("Caisse not found"));

        Transaction transaction = Transaction.builder()

                .montant(dto.getMontant())
                .operationType(dto.getOperationType())
                .caisse(caisse)
                .customerId(dto.getCustomerId())
                .pvId(dto.getPvId())
                .creancierId(dto.getCreancierId())
                .build();


        if(transaction.getOperationType() == OperationType.CREDIT){
            caisse.setSolde(caisse.getSolde().add(transaction.getMontant()));
        }else caisse.setSolde(caisse.getSolde().subtract(transaction.getMontant()));

        transaction.setCaisse(caisse);

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setId(123456L);
        invoiceDto.setDateInvoice(LocalDate.now());
        invoiceDto.setCreancierId(dto.getCreancierId());
        invoiceDto.setCustomerId(dto.getCustomerId());
        invoiceDto.setModeReglement(ModeReglement.ESPECES);
        invoiceDto.setPointDeVenteId(45L);
        invoiceDto.setReference("2356L");
        invoiceDto.setStatus(StatusInvoice.EN_ATTENTE);
        invoiceExternalProxy.create(invoiceDto);

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