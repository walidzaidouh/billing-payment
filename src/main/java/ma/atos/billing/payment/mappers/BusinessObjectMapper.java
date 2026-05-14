package ma.atos.billing.payment.mappers;

import ma.atos.billing.payment.dto.BusinessObjectDto;
import ma.atos.billing.payment.models.BusinessObject;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface BusinessObjectMapper {

    BusinessObjectDto toDto(BusinessObject entity);

    BusinessObject toEntity(BusinessObjectDto dto);

    List<BusinessObjectDto> toDtoList(List<BusinessObject> entities);
}

