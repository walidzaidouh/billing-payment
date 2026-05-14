package ma.atos.billing.payment.Controllers;


import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.web.bind.annotation.*;

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

        @GetMapping("/customer/{id}")
        public List<Transaction> getTransactionsByCustomer(@PathVariable Long id){
            return transactionService.getAllTransByCustomer(id);
        }












}
