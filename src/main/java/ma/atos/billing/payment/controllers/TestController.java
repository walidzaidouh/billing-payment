package ma.atos.billing.payment.controllers;


import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.dto.InvoiceDto;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.enums.ModeReglement;
import ma.atos.billing.payment.enums.PaymentType;
import ma.atos.billing.payment.enums.StatusInvoice;
import ma.atos.billing.payment.messaging.InvoiceConsumer;
import ma.atos.billing.payment.messaging.PayementEventPubilsh;
import ma.atos.billing.payment.proxies.InvoiceExternalProxy;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {


    private final PayementEventPubilsh payementEventPubilsh;

    private final InvoiceConsumer invoiceConsumer;

    @GetMapping("/test")
    public ResponseEntity<Void>  test(){
        payementEventPubilsh.publishPaymentRequest(TransactionDTO.builder().transactionId(45L).montant(BigDecimal.valueOf(2000L)).build());
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/consumer")
    public ResponseEntity<Void> consumer() {

        InvoiceDto dto = InvoiceDto.builder()
                .id(34L)
                .reference("INV-001")
                .dateInvoice(LocalDate.now())
                .dateDue(LocalDate.now().plusDays(30))
                .montantHt(100.0)
                .montantTva(20.0)
                .montantTtc(120.0)
                .status(StatusInvoice.EN_ATTENTE)
                .modeReglement(PaymentType.CHEQUE)
                .description("Test invoice")
                .customerId(1L)
                .creancierId(5L)
                .pointDeVenteId(6L)
                .build();

        invoiceConsumer.consumeInvoice(dto);

        return ResponseEntity.noContent().build();
    }
}
