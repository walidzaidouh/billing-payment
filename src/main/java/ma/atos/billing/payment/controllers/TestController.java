package ma.atos.billing.payment.controllers;


import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.listenenersAndProducers.TransactionProducer;
import ma.atos.billing.payment.proxies.InvoiceExternalProxy;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {

    private final TransactionProducer producer;

    public TestController(TransactionProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String send(@RequestBody TransactionDTO dto) {
        producer.sendTransaction(dto);
        return "Transaction sent!";
    }
}
