package co.com.randomapi.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "Student")
@Table(name = "students")
public class Student extends Person {
    @Id
    @Column(name = "id", unique = true)
    @GenericGenerator(name = "student_id_generator", strategy = "identity")
    @GeneratedValue(generator = "student_id_generator")
    protected Long Id;

    private Double salary;

    @ManyToMany(mappedBy = "subscribedStudents", fetch = FetchType.EAGER)
    private List<Subject> subscribedTo;
}
