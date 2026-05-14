package ma.atos.billing.payment.Controllers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.billing.payment.Services.CaisseService;
import ma.atos.billing.payment.Services.RecService;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;
import org.springframework.stereotype.Controller;
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
    public Reconciliation executeStlm(
            @RequestParam Long idCaisse,
            @RequestParam BigDecimal soldeFin
    ) {
        Caisse caisse = caisseService.getById(idCaisse);
        return recService.executeStlm(caisse, soldeFin);
    }
}