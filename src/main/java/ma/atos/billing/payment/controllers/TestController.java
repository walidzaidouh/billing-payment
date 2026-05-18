package ma.atos.billing.payment.controllers;


import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.proxies.InvoiceExternalProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {

    public final InvoiceExternalProxy invoiceExternalProxy;

    @GetMapping("/test")
    public
}
