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
    private ProfessorDTO assignedProfessor;
    private Set<StudentDTO> subscribedStudents;

    public SubjectDTO(String name, SubjectDifficulty difficulty, ProfessorDTO professorInCharge, Set<StudentDTO> subscribedStudents) {
        this.name = name;
        this.difficulty = difficulty;
        this.assignedProfessor = professorInCharge;
        this.subscribedStudents = subscribedStudents;
    }

    public void suscribeStudent(StudentDTO dto) {
        this.subscribedStudents.add(dto);
    }
}
