package ma.atos.billing.payment.listenenersAndProducers;


import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.dto.CustomerDTO;
import ma.atos.billing.payment.dto.TransactionCreationDTO;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.enums.StatusInvoice;
import ma.atos.billing.payment.proxies.InvoiceExternalProxy;
import ma.atos.billing.payment.services.TransactionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class PaymentInitiationListener {


    private final TransactionProducer transactionProducer ;

    private final TransactionService transactionService ;

    @RabbitListener(queues = "PAYMENT_INITIATION_QUEUE")
    public void consume(CustomerDTO customer) {

        System.out.println("✅ Received customer: " + customer);


        if (customer != null) {
            TransactionDTO tx = transactionService.save(TransactionCreationDTO.builder().operationType(OperationType.CREDIT).montant(BigDecimal.valueOf(300)).customerId(customer.getId()).pvId(3L).caisseId(5L).build());
            tx.setInvoiceId(1026L);
            tx.setPdvId(3L);
            transactionProducer.sendTransaction(tx);

        }
    }

        @RabbitListener(queues = "PAYMENT_STATUS_QUEUE")
        public void consume(ResponseStatusInvoice response) {

            System.out.println("✅ Received Invoice id and status: " + response);


            if (response != null) {
                TransactionDTO transactionDTO = transactionService.getTransactionByID(response.id()) ;

                transactionDTO.setInvoiceId(response.invoiceId());
                // todo : modifier la structure de la table transaction .
            }



    }

}



