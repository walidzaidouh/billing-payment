package ma.atos.billing.payment.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.atos.billing.payment.Services.CaisseService;
import ma.atos.billing.payment.models.Caisse;
import ma.atos.billing.payment.models.Reconciliation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/caisse")
@AllArgsConstructor
@Tag(name = "Caisse API", description = "Operations related to caisse management")
public class CaisseApi {

    private final CaisseService caisseService;

    @Operation(summary = "Create a new caisse")
    @PostMapping("/create")
    public Caisse ajouterCaisse(@RequestBody Caisse caisse) {
        return caisseService.save(caisse);
    }
}