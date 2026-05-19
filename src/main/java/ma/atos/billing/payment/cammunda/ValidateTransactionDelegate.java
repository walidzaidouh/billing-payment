package ma.atos.billing.payment.cammunda;


import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("validateDelegate")
@RequiredArgsConstructor
public class ValidateTransactionDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        BigDecimal montant = (BigDecimal) execution.getVariable("montant");

        if (montant == null) {
            throw new RuntimeException("Montant is required");
        }

        if (montant.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Montant must be > 0");
        }

        // log for testing
        System.out.println("✅ Validation passed: " + montant);

    }
}
