package co.com.pragma.inmemorydb;

import co.com.pragma.inmemorydb.mapper.CustomerMapper;
import co.com.pragma.model.customer.Customer;
import co.com.pragma.model.customer.gateways.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class H2RepositoryAdapter implements CustomerRepository {


    @Autowired
    private  H2Repository h2Repository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Flux<Customer> getAllCustomers() {
        return this.h2Repository.findAll()
                .map(customerDto -> this.customerMapper.toDomain(customerDto));
    }

    @Override
    public Mono<Customer> getCustomer(Integer id) {
        return this.h2Repository.findById(id)
                .map(customerDto -> this.customerMapper.toDomain(customerDto));
    }
}
