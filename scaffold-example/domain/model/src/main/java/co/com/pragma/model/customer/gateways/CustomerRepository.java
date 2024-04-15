package co.com.pragma.model.customer.gateways;

import co.com.pragma.model.customer.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CustomerRepository {

    Flux<Customer> getAllCustomers();
    Mono<Customer> getCustomer(Integer id);
}
