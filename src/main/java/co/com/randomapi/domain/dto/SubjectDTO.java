package co.com.randomapi.domain.dto;

import co.com.randomapi.persistence.entity.SubjectDifficulty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private long id;
    private String name;
    private SubjectDifficulty difficulty;
    private ProfessorDTO professorInCharge;
    private List<StudentDTO> subscribedStudents;
}
