package ma.atos.billing.payment.DTO;


import ma.atos.billing.payment.models.Transaction;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring",unmappedTargetPolicy = IGNORE)
public interface TransactionMapper {

    TransactionDTO toTransactionDto(Transaction transaction);

    Transaction ToTransactionEntity(TransactionDTO transactionDto);

}
