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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetCustomerUseCaseTest {

    @InjectMocks
    private GetCustomerUseCase getCustomerUseCase;
    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void getCustomerReturnsItem(){

    }

    @Test
    public void getCustomerReturnsItemWithDefaultGender(){

    }

    @Test
    public void getCustomerReturnsErrorNotFound(){

    }
}