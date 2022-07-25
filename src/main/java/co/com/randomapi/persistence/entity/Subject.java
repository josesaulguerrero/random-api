package co.com.randomapi.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Subject")
@Table(name = "subjects")
public class Subject {
    @Id
    @Column(name = "id", unique = true)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private SubjectDifficulty difficulty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_professor")
    private Professor professorInCharge;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subject_student",
            joinColumns = { @JoinColumn(name = "fk_subject") },
            inverseJoinColumns = { @JoinColumn(name = "fk_student") }
    )
    private Set<Student> subscribedStudents;
}
