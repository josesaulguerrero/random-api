package co.com.randomapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "professors")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Professor extends Person {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    private Double salary;

    @OneToMany(mappedBy = "assignedProfessor", fetch = FetchType.EAGER)
    private Set<Subject> subjectsInCharge;

    public Professor(String DNI, String name, Integer age, Double salary, Set<Subject> subjectsInCharge) {
        super(DNI, name, age);
        this.salary = salary;
        this.subjectsInCharge = subjectsInCharge;
    }

    public Professor(String DNI, String name, Integer age, Long id, Double salary, Set<Subject> subjectsInCharge) {
        super(DNI, name, age);
        this.id = id;
        this.salary = salary;
        this.subjectsInCharge = subjectsInCharge;
    }
}
