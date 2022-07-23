package co.com.randomapi.persistence.entity;

import lombok.*;

import javax.persistence.*;

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
    private Long Id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private SubjectDifficulty difficulty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_professor")
    private Professor professorInCharge;
}
