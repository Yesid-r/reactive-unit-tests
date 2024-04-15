package co.com.pragma.model.customer.errors;

import co.com.pragma.model.customer.enums.ErrorType;
import lombok.Getter;

@Getter
public class DomainException extends RuntimeException{
    private final ErrorType errorType;
    public DomainException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
}
