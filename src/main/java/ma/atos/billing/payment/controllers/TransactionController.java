package ma.atos.billing.payment.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.dto.TransactionCreationDTO;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.services.Impl.CammundaTestService;
import ma.atos.billing.payment.services.TransactionService;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Customer;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Tag(name = "Transaction API", description = "Operations related to transactions")
public class TransactionController {

    private final TransactionService transactionService;

    private final CammundaTestService cammundaService;


    @Operation(summary = "Get transaction by ID")
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok(
                transactionService.getTransactionByID(id)
        );
    }

    @Operation(summary = "Create a new transaction")
    @PostMapping("/create")
    public ResponseEntity<TransactionDTO> create(
            @RequestBody TransactionCreationDTO dto
    ) {

        return ResponseEntity.ok(
                transactionService.save(dto)
        );
    }

    @Operation(summary = "Get all transactions for a customer")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<TransactionDTO>> getByCustomer(
            @PathVariable Long customerId
    ) {

        Customer customer = new Customer();
        customer.setId(customerId);

        return ResponseEntity.ok(
                transactionService.findByCustomerId(customerId)
        );
    }

    @Operation(summary = "Get all transactions for a caisse")
    @GetMapping("/caisse/{caisseId}")
    public ResponseEntity<List<TransactionDTO>> getByCaisse(
            @PathVariable Long caisseId
    ) {

        Caisse caisse = new Caisse();
        caisse.setId(caisseId);

        return ResponseEntity.ok(
                transactionService.getTrasactionByCaisse(caisse)
        );
    }

    @Operation(summary = "Get transaction amount")
    @GetMapping("/{id}/amount")
    public ResponseEntity<BigDecimal> getAmount(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                transactionService.getTransactionAmount(id)
        );
    }

    @Operation(summary = "Delete transaction")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        transactionService.delete(id);

        return ResponseEntity.noContent().build();
    }


    @PostMapping("/validate")
    public ResponseEntity<String> test(@RequestParam BigDecimal montant) {

        cammundaService.testValidation(montant);

        return ResponseEntity.ok("Process started");
    }

}
