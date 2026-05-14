package ma.atos.billing.payment.Controllers;


import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/customer/{id}")
    public List<Transaction> getTransactionsByCustomer(@PathVariable Long id){
        return transactionService.getAllTransByCustomer(id);
    }
}

