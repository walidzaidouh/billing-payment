package ma.atos.billing.payment.mappers;

import ma.atos.billing.payment.dto.TransactionDTO;
import ma.atos.billing.payment.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {


    TransactionDTO toDto(Transaction entity);


    Transaction toEntity(TransactionDTO dto);

    List<TransactionDTO> toDtoList(List<Transaction> entities);
}