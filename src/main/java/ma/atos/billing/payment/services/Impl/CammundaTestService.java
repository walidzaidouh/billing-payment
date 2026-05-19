package ma.atos.billing.payment.services.Impl;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CammundaTestService {


    private final RuntimeService runtimeService;

    public void testValidation(BigDecimal montant) {

        Map<String, Object> vars = new HashMap<>();
        vars.put("montant", montant);


        runtimeService.startProcessInstanceByKey("transactionProcess", vars);

    }

}
