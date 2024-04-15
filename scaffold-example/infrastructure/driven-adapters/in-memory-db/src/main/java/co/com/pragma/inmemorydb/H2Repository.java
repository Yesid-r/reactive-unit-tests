package co.com.pragma.inmemorydb;

import co.com.pragma.inmemorydb.dto.CustomerDto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;


public interface H2Repository extends R2dbcRepository<CustomerDto, Integer> {
}
