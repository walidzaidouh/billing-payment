package ma.atos.billing.payment.messaging;


import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.config.RabbitMqConfig;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.enums.PaymentType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor
public class PayementEventPubilsh {

    private final RabbitTemplate rabbitTemplate;


    public void publishPaymentRequest(TransactionDTO transactionDTO) {
        PaymentRequestEvent event = new PaymentRequestEvent(
                transactionDTO.getTransactionId(),
                transactionDTO.getMontant(),
                transactionDTO.getCaisseId(),
                transactionDTO.getOperationType(),
                transactionDTO.getPdvId()
        );


        rabbitTemplate.convertAndSend(
                RabbitMqConfig.INVOICE_Q,event
        );
    }
}
