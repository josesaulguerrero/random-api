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
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professorInCharge;
}
