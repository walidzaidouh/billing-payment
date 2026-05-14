package ma.atos.billing.payment.mappers;


import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.models.Caisse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CaisseMapper {

    CaisseMapper instance = Mappers.getMapper(CaisseMapper.class);


    CaisseDTO toCaisseDto(Caisse caisse);

    Caisse toCaisseEntity(CaisseDTO caisseDTO);

}
