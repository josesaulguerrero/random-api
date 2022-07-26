package co.com.randomapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "students")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Student extends Person {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "fk_student"),
            inverseJoinColumns = @JoinColumn(name = "fk_subject")
    )
    private Set<Subject> subscribedTo;

    public Student(String dni, String name, Integer age, Set<Subject> subscribedTo) {
        super(dni, name, age);
        this.subscribedTo = subscribedTo;
    }

    public Student(String dni, String name, Integer age, Long id, Set<Subject> subscribedTo) {
        super(dni, name, age);
        this.id = id;
        this.subscribedTo = subscribedTo;
    }
}
