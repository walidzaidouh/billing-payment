package ma.atos.billing.payment.mappers;

import ma.atos.billing.payment.dto.CustomerDTO;
import ma.atos.billing.payment.models.Customer;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerDTO toDto(Customer entity);

    Customer toEntity(CustomerDTO dto);

    List<CustomerDTO> toDtoList(List<Customer> entities);
}