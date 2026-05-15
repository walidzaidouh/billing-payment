package ma.atos.billing.payment.services.Impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.dto.ReconciliationDTO;
import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.mappers.CaisseMapper;
import ma.atos.billing.payment.mappers.ReconciliationMapper;
import ma.atos.billing.payment.repositories.ReconciliationRepository;
import ma.atos.billing.payment.services.RecService;
import ma.atos.billing.payment.enums.OperationType;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;
import ma.atos.billing.payment.models.Transaction;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class RecServiceImpl implements RecService {

    private final ReconciliationRepository reconciliationRepository;
    private  final CaisseMapper caisseMapper ;
    private final ReconciliationMapper reconciliationMapper  ;

    @Override
    public ReconciliationDTO executeStlm(CaisseDTO caisse, BigDecimal soldeFin) {

        List<TransactionDTO> transactions = caisse.getTransactions();

        BigDecimal amountDebit = BigDecimal.ZERO;
        BigDecimal amountCredit = BigDecimal.ZERO;

        for (TransactionDTO t : transactions) {

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

        Caisse caisseEn = caisseMapper.toCaisseEntity(caisse);
        Reconciliation rec = Reconciliation.builder()
                .caisse(caisseEn)
                .totalDebit(amountDebit)
                .totalCredit(amountCredit)
                .isCorrect(isCorrect)
                .build();

        return reconciliationMapper.toDto(reconciliationRepository.save(rec));
    }
}
