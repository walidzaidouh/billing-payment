package ma.atos.billing.payment.Controllers;


import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/Transactions")
@RequiredArgsConstructor
public class TransactionController {

     private final TransactionService transactionService;

    @PostMapping("/{customerId}")
    public Transaction createTransaction(@RequestBody Transaction transaction,
                              @PathVariable Long customerId) {
        return transactionService.createTransaction(transaction, customerId);
    }

    @GetMapping("/pv/{pvId}")
    public List<Transaction> getTransactionsByPv(@PathVariable Long pvId) {
        return transactionService.getAllTransactionByPV(pvId);
    }

    @GetMapping("/creancier/{creancierId}")
    public List<Transaction> getTransactionsByCreancier(@PathVariable Long creancierId) {
        return transactionService.getAllTransactionByCreancier(creancierId);
    }

    @GetMapping("/customer/{id}")
    public List<Transaction> getTransactionsByCustomer(@PathVariable Long id){
        return transactionService.getAllTransByCustomer(id);
    }
}
