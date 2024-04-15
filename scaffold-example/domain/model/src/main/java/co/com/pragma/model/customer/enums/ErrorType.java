package co.com.pragma.model.customer.enums;

import co.com.pragma.model.customer.errors.DomainException;
import lombok.Getter;

@Getter
public enum ErrorType {

    CUSTOMER_NOT_FOUND("No customer was found with the id provided");

    private final String description;

    ErrorType(String description) {
        this.description = description;
    }

    public DomainException build() {
        return new DomainException(this, this.description);
    }
}
