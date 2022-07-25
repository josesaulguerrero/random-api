package co.com.randomapi.persistence.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "Person")
@Table(name = "people")
public class Professor extends Person {
    @Id
    @Column(name = "id", unique = true)
    @GenericGenerator(name = "professor_id_generator", strategy = "identity")
    @GeneratedValue(generator = "professor_id_generator")
    protected Long id;

    private Double salary;

    @Column(name = "subjects_in_charge_of")
    @OneToMany(mappedBy = "professorInCharge", fetch = FetchType.EAGER)
    private List<Subject> subjectsInCharge;

    public Professor(String DNI, String name, Integer age, Double salary, List<Subject> subjectsInCharge) {
        super(DNI, name, age);
        this.salary = salary;
        this.subjectsInCharge = subjectsInCharge;
    }

    public Professor(String DNI, String name, Integer age, Long id, Double salary, List<Subject> subjectsInCharge) {
        super(DNI, name, age);
        this.id = id;
        this.salary = salary;
        this.subjectsInCharge = subjectsInCharge;
    }
}
