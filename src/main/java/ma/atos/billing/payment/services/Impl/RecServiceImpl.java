package ma.atos.billing.payment.services.Impl;

import lombok.AllArgsConstructor;
import ma.atos.billing.payment.repositories.ReconciliationRepository;
import ma.atos.billing.payment.services.RecService;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;
import ma.atos.billing.payment.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class RecServiceImpl implements RecService {

    private final ReconciliationRepository reconciliationRepository;


    @Override
    public Reconciliation executeStlm(Caisse caisse, BigDecimal soldeFin) {

        List<Transaction> transactions = caisse.getTransactions();

        BigDecimal amountDebit = BigDecimal.ZERO;
        BigDecimal amountCredit = BigDecimal.ZERO;

        for (Transaction t : transactions) {

            if (t.getOperationType() == OperationType.CREDIT) {
                amountCredit = amountCredit.add(t.getMontant());
            } else {
                amountDebit = amountDebit.add(t.getMontant());
            }
        }

        BigDecimal calculatedSolde =
                caisse.getMontantDepart()
                        .add(amountCredit)
                        .subtract(amountDebit);

        boolean isCorrect =
                calculatedSolde.compareTo(soldeFin) == 0;

        Reconciliation rec = Reconciliation.builder()
                .caisse(caisse)
                .totalDebit(amountDebit)
                .totalCredit(amountCredit)
                .isCorrect(isCorrect)
                .build();

        return reconciliationRepository.save(rec);
    }
}
