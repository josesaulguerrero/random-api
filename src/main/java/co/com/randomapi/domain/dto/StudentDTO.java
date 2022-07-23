package co.com.randomapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private int age;
    private String dni;
    private List<SubjectDTO> subscribedTo;

    public StudentDTO(String name, int age, String dni, List<SubjectDTO> subscribedTo) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.subscribedTo = subscribedTo;
    }
}
