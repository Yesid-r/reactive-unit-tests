package co.com.pragma.usecase.getcustomers;

import co.com.pragma.model.customer.Customer;
import co.com.pragma.model.customer.constants.CustomerConstants;
import co.com.pragma.model.customer.enums.ErrorType;
import co.com.pragma.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class GetAllCustomersUseCase {

    private final CustomerRepository customerRepository;

    public Flux<Customer> action() {
        return this.customerRepository.getAllCustomers()
                .map(customer -> {
                    if (Objects.isNull(customer.getGender())){
                        customer.setGender(CustomerConstants.DEFAULT_GENDER);
                    }
                    return customer;
                })
                .switchIfEmpty(Mono.error(ErrorType.CUSTOMER_NOT_FOUND.build()));
    }

}
