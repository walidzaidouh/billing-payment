package ma.atos.billing.payment.services.Impl;

import lombok.AllArgsConstructor;
import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.dto.ReconciliationDTO;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.mappers.CaisseMapper;
import ma.atos.billing.payment.mappers.ReconciliationMapper;
import ma.atos.billing.payment.repositories.CaisseRepository;
import ma.atos.billing.payment.repositories.ReconciliationRepository;
import ma.atos.billing.payment.services.RecService;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class RecServiceImpl implements RecService {

    private final ReconciliationRepository reconciliationRepository;
    private  final CaisseMapper caisseMapper ;
    private final ReconciliationMapper reconciliationMapper  ;

    private final CaisseRepository caisseRepository ;

    @Override
    public ReconciliationDTO executeStlm(CaisseDTO caisse, BigDecimal soldeFin) {
        if (!caisse.isClosed()) {
            throw new IllegalStateException("Caisse must be closed before reconciliation");
        }        List<TransactionDTO> transactions = caisse.getTransactions();

        BigDecimal amountDebit = BigDecimal.ZERO;
        BigDecimal amountCredit = BigDecimal.ZERO;

        for (TransactionDTO t : transactions) {

            if (t.getOperationType() == OperationType.fromValue("credit")) {
                amountCredit = amountCredit.add(t.getMontant());
            } else {
                amountDebit = amountDebit.add(t.getMontant());
            }
        }

        BigDecimal calculatedSolde =
                caisse.getMontantDepart()
                        .add(amountCredit)
                        .subtract(amountDebit);

        boolean isCorrect =(calculatedSolde.equals(soldeFin));

        Caisse caisseEn = caisseRepository.findById(caisse.getId())
                .orElseThrow(() -> new RuntimeException("Caisse not found with id: " + caisse.getId()));
        Reconciliation rec = Reconciliation.builder()
                .caisse(caisseEn)
                .totalDebit(amountDebit)
                .totalCredit(amountCredit)
                .isCorrect(isCorrect)
                .build();

        return reconciliationMapper.toDto(reconciliationRepository.save(rec));
    }
}
