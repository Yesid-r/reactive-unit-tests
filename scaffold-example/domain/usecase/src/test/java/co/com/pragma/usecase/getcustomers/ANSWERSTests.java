package co.com.pragma.usecase.getcustomers;

import co.com.pragma.model.customer.Customer;
import co.com.pragma.model.customer.constants.CustomerConstants;
import co.com.pragma.model.customer.errors.DomainException;
import co.com.pragma.model.customer.gateways.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ANSWERSTests {

    @InjectMocks
    private GetCustomerUseCase getCustomerUseCase;

    @InjectMocks
    private GetAllCustomersUseCase getAllCustomersUseCase;

    @Mock
    private CustomerRepository customerRepository;



    @Test
    public void getCustomerReturnsItem() {
        given(this.customerRepository.getCustomer(anyInt())).willReturn(Mono.just(Customer.builder().build()));
        var result = getCustomerUseCase.action(123);
        StepVerifier.create(result)
                .expectNextCount(1)
                .verifyComplete();

    }

    @Test
    public void getCustomerReturnsItemWithDefaultGender() {
        given(this.customerRepository.getCustomer(anyInt())).willReturn(Mono.just(Customer.builder().build()));
        var result = getCustomerUseCase.action(123);
        StepVerifier.create(result)
                .expectNextMatches(customer -> CustomerConstants.DEFAULT_GENDER.equals(customer.getGender()))
                .verifyComplete();

    }

    @Test
    public void getCustomerReturnsErrorNotFound() {
        given(this.customerRepository.getCustomer(anyInt())).willReturn(Mono.empty());
        var result = getCustomerUseCase.action(123);
        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

    }


    @Test
    public void getAllCustomersReturnsTwoItems() {
        Flux<Customer> data = Flux.just(Customer.builder().customerId(1).build(), Customer.builder().customerId(2).build());
        given(this.customerRepository.getAllCustomers()).willReturn(data);
        var result = getAllCustomersUseCase.action();
        StepVerifier.create(result)
                .expectNextCount(2)
                .verifyComplete();

    }

    @Test
    public void getAllCustomersReturnsErrorNotFound() {
        given(this.customerRepository.getAllCustomers()).willReturn(Flux.empty());
        var result = getAllCustomersUseCase.action();
        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

    }
}
