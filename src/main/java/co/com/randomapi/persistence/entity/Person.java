package co.com.randomapi.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(value = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PROTECTED)
@ToString
@MappedSuperclass
public abstract class Person<T extends Serializable> {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "id_generator")
    protected T id;
    protected String DNI;
    protected String name;
    protected Integer age;

    protected Person(String DNI, String name, Integer age) {
        this.DNI = DNI;
        this.name = name;
        this.age = age;
    }
}
