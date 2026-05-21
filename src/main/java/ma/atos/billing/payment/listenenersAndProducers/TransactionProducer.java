package ma.atos.billing.payment.listenenersAndProducers;

import ma.atos.billing.payment.dto.TransactionDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    private final ProducerTemplate producerTemplate;

    public TransactionProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void sendTransaction(TransactionDTO transaction) {
        producerTemplate.sendBody("direct:sendTransaction", transaction);
    }
}