package ma.atos.billing.payment.Services.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.Repositories.CaisseRepository;
import ma.atos.billing.payment.Repositories.ReconciliationRepository;
import ma.atos.billing.payment.Services.RecService;
import ma.atos.billing.payment.Services.TransactionService;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecServiceImpl implements RecService {


    ReconciliationRepository reconciliationRepository ;

    TransactionService transactionService ;

    CaisseRepository caisseRepository ;
    @Override
    public Reconciliation executeStlm(Caisse caisse,BigDecimal soldeFin) {

        List<Transaction> transactions = caisse.getTransactions() ;
        BigDecimal amountDebit = BigDecimal.ZERO;
        BigDecimal amountCredit = BigDecimal.ZERO;

        for (Transaction t : transactions) {

            if (t.getOperationType().equals(OperationType.CREDIT)) {

                amountCredit = amountCredit.add(t.getMontant());

            } else {

                amountDebit = amountDebit.add(t.getMontant());
            }
        }
        BigDecimal calculatedSolde =
                caisse.getMontantDepart()
                        .add(amountCredit)
                        .subtract(amountDebit);
        boolean isCorrect = calculatedSolde.equals(soldeFin) ;
        Reconciliation rec = new Reconciliation(caisse ,amountDebit,amountCredit,isCorrect) ;
        return rec;
    }
}
