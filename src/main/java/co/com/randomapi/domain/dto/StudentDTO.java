package co.com.randomapi.domain.dto;

import co.com.randomapi.persistence.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private int age;
    private String dni;
    private Set<Subject> subscribedTo;

    public StudentDTO(String name, int age, String dni, Set<Subject> subscribedTo) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.subscribedTo = subscribedTo;
    }
}
