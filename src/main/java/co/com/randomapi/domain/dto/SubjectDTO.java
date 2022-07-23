package co.com.randomapi.domain.dto;

import co.com.randomapi.persistence.entity.SubjectDifficulty;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private long id;
    private String name;
    private SubjectDifficulty difficulty;
    private ProfessorDTO professorInCharge;
    private Set<StudentDTO> subscribedStudents;

    public SubjectDTO(String name, SubjectDifficulty difficulty, ProfessorDTO professorInCharge, Set<StudentDTO> subscribedStudents) {
        this.name = name;
        this.difficulty = difficulty;
        this.professorInCharge = professorInCharge;
        this.subscribedStudents = subscribedStudents;
    }
}
