package ma.atos.billing.payment.proxies;


import ma.atos.billing.payment.dto.InvoiceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="${app.feign-clients.reference-service.name}" ,url ="${app.feign-clients.reference-service.url}",path = "/api/invoices")
public interface InvoiceExternalProxy {

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable Long id);

}
