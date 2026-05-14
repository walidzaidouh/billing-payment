package ma.atos.billing.payment.controllers;


import lombok.AllArgsConstructor;
import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.dto.ReconciliationDTO;
import ma.atos.billing.payment.services.CaisseService;
import ma.atos.billing.payment.services.RecService;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
public class SettlementApi {

    private final CaisseService caisseService;
    private final RecService recService;

    @PostMapping("/settle")
    public ReconciliationDTO executeStlm(
            @RequestParam Long idCaisse,
            @RequestParam BigDecimal soldeFin
    ) {
        CaisseDTO caisse = caisseService.getById(idCaisse);
        return recService.executeStlm(caisse, soldeFin);
    }
}