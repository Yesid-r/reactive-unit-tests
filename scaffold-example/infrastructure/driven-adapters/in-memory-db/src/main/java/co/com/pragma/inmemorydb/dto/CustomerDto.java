package co.com.pragma.inmemorydb.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "customer")
public class CustomerDto {

    @Id
    @Column(value = "customerId")
    private Integer customerId;
    @Column(value = "firstName")
    private String firstName;
    @Column(value = "lastName")
    private String lastName;
    @Column(value = "gender")
    private String gender;
}
