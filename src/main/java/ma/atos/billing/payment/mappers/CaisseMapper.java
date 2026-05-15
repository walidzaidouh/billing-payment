package ma.atos.billing.payment.mappers;


import ma.atos.billing.payment.dto.CaisseDTO;
import ma.atos.billing.payment.models.Caisse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Mapper(componentModel = "spring", uses = {TransactionMapper.class})

public interface CaisseMapper {


    CaisseDTO toCaisseDto(Caisse caisse);

    Caisse toCaisseEntity(CaisseDTO caisseDTO);

    List<CaisseDTO> toCaisseDtoList(List<Caisse> caisses);

    List<Caisse> toCaisseList(List<CaisseDTO> caisseDTOS);
}
