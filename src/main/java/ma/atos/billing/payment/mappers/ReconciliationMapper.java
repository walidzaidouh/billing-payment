package ma.atos.billing.payment.mappers;

import ma.atos.billing.payment.dto.ReconciliationDTO;
import ma.atos.billing.payment.models.Reconciliation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReconciliationMapper {


    @Mapping(source = "caisse.id", target = "caisseId")
    @Mapping(source = "isCorrect", target = "correct")
    ReconciliationDTO toDto(Reconciliation entity);

    @Mapping(source = "caisseId", target = "caisse.id")
    @Mapping(source = "correct", target = "isCorrect")
    Reconciliation toEntity(ReconciliationDTO dto);


    List<ReconciliationDTO> toDtoList(List<Reconciliation> entities);
}