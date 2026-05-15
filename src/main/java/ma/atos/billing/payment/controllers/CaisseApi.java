package ma.atos.billing.payment.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.services.CaisseService;
import ma.atos.billing.payment.models.Caisse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/caisse")
@RequiredArgsConstructor
@Tag(name = "Caisse API", description = "Operations related to caisse management")
public class CaisseApi {

    private final CaisseService caisseService;

    @Operation(summary = "Create a new caisse")
    @PostMapping("/create")
    public ResponseEntity<Caisse> ajouterCaisse(
            @RequestBody Caisse caisse
    ) {

        return ResponseEntity.ok(
                caisseService.save(caisse)
        );
    }

    @Operation(summary = "Get caisse by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Caisse> getById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                caisseService.getById(id)
        );
    }

    @Operation(summary = "Open caisse")
    @PutMapping("/{id}/open")
    public ResponseEntity<Boolean> ouvrirCaisse(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                caisseService.ouvrirCaisse(id)
        );
    }

    @Operation(summary = "Close caisse and execute reconciliation")
    @PutMapping("/{id}/close")
    public ResponseEntity<Boolean> fermerCaisse(
            @PathVariable Long id,
            @RequestParam BigDecimal soldeFin
    ) {

        return ResponseEntity.ok(
                caisseService.closeRegister(id, soldeFin)
        );
    }

    @Operation(summary = "Delete caisse")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        caisseService.delete(id);

        return ResponseEntity.noContent().build();
    }
}