package ma.atos.billing.payment.mappers;

import ma.atos.billing.payment.dto.ReconciliationDTO;
import ma.atos.billing.payment.models.Reconciliation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReconciliationMapper {



    ReconciliationDTO toDto(Reconciliation entity);



    Reconciliation toEntity(ReconciliationDTO dto);


    List<ReconciliationDTO> toDtoList(List<Reconciliation> entities);
}