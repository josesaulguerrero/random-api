package co.com.randomapi.domain.dto;

import co.com.randomapi.persistence.entity.Subject;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private long id;
    private String name;
    private int age;
    private String dni;
    private double salary;
    private List<Subject> subjectsInCharge;

    public ProfessorDTO(String name, int age, String dni, double salary, List<Subject> subjectsInCharge) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.salary = salary;
        this.subjectsInCharge = subjectsInCharge;
    }
}
