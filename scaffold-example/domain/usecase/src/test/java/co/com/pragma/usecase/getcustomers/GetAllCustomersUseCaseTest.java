package co.com.pragma.usecase.getcustomers;

import co.com.pragma.model.customer.Customer;
import co.com.pragma.model.customer.errors.DomainException;
import co.com.pragma.model.customer.gateways.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetAllCustomersUseCaseTest {

    @InjectMocks
    private GetAllCustomersUseCase getAllCustomersUseCase;
    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void getAllCustomersReturnsTwoItems(){

    }

    @Test
    public void getAllCustomersReturnsErrorNotFound(){

    }
}