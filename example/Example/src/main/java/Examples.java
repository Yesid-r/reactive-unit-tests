import dto.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Examples {

    public static Mono<String> showMessage(){
        return Mono.just("Eres piloto de tu destino");
    }

    public static Mono<String> customersNameById(String id){
        return Flux.just(new Customer("1","Pedro"), new Customer("2","Carlos"), new Customer("3","Jose"))
                .filter(customer -> customer.getId().equals(id))
                .next()
                .map(Customer::getName);
    }

    public static Flux<String> upperCaseMessage(){
        return Flux.just("No", null, "Trago", "Entero")
                .map(String::toUpperCase);
    }
}
