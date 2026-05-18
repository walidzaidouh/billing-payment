package ma.atos.billing.payment.proxies;


import jakarta.validation.Valid;
import ma.atos.billing.payment.dto.InvoiceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="${app.feign-clients.reference-service.name}" ,url ="${app.feign-clients.reference-service.url}",path = "/api/invoices")
public interface InvoiceExternalProxy {

    @PostMapping()
    ResponseEntity<InvoiceDto> create(@Valid @RequestBody InvoiceDto dto) ;

}
