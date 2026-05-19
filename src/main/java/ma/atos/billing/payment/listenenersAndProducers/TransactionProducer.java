package ma.atos.billing.payment.listenenersAndProducers;

import ma.atos.billing.payment.dto.TransactionDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    private final RabbitTemplate rabbitTemplate;

    public TransactionProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTransaction(TransactionDTO transaction) {
        rabbitTemplate.convertAndSend(
                "INVOICE_QUEUE",   // queue name
                transaction       // message
        );
    }
}