package ma.atos.billing.payment.messaging;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.support.converter.MessageConverter;
import ma.atos.billing.payment.config.RabbitMqConfig;
import ma.atos.billing.payment.dto.InvoiceDto;
import ma.atos.billing.payment.enums.StatusInvoice;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InvoiceConsumer {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitMqConfig.INVOICE_Q)
    public void consumeInvoice(InvoiceDto invoiceDto) {

        System.out.println("Invoice reçue : " + invoiceDto);

        invoiceDto.setStatus(StatusInvoice.PAYEE);

        rabbitTemplate.convertAndSend(
                "",
                RabbitMqConfig.PAYMENT_STATUS_Q,
                invoiceDto
        );
    }

}
