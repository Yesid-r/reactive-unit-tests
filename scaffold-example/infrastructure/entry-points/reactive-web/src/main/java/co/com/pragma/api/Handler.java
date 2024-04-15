package co.com.pragma.api;

import co.com.pragma.model.customer.errors.DomainException;
import co.com.pragma.usecase.getcustomers.GetAllCustomersUseCase;
import co.com.pragma.usecase.getcustomers.GetCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final GetCustomerUseCase getCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    public Mono<ServerResponse> listenGETCustomerUseCase(ServerRequest serverRequest) {
        String customerId =  serverRequest.pathVariable("customerId");
        return getCustomerUseCase.action(Integer.valueOf(customerId))
                .flatMap(customer -> ServerResponse.ok().bodyValue(customer))
                .onErrorResume(DomainException.class, e -> ServerResponse.notFound().build())
                .onErrorResume(throwable -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build());
    }
    public Mono<ServerResponse> listenGETAllCustomersUseCase(ServerRequest serverRequest) {
        return getAllCustomersUseCase.action()
                .collectList()
                .flatMap(customers -> ServerResponse.ok().bodyValue(customers))
                .onErrorResume(DomainException.class, e -> ServerResponse.notFound().build())
                .onErrorResume(throwable -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build());
    }

}
