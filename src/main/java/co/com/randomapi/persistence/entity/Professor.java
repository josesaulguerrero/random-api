package co.com.randomapi.persistence.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "Person")
@Table(name = "people")
@GenericGenerator(name = "id_generator", strategy = "IDENTITY")
public class Professor extends Person<Long> {
    private Double salary;

    @OneToMany(mappedBy = "professorInCharge", fetch = FetchType.EAGER)
    private List<Subject> subjectsInCharge;
}
