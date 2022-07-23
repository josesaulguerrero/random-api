package co.com.randomapi.domain.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private Long id;
    private String name;
    private int age;
    private String dni;
    private double salary;
    private List<SubjectDTO> subjectsInCharge;

    public ProfessorDTO(String name, int age, String dni, double salary, List<SubjectDTO> subjectsInCharge) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.salary = salary;
        this.subjectsInCharge = subjectsInCharge;
    }
}
