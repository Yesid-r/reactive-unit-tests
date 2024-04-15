package co.com.pragma.inmemorydb.mapper;

import co.com.pragma.inmemorydb.dto.CustomerDto;
import co.com.pragma.model.customer.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toDomain(CustomerDto customerDto);
}
