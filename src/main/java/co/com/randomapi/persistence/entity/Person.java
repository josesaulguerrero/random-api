package co.com.randomapi.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@ToString
@MappedSuperclass
public abstract class Person {
    @Column(unique = true, name = "dni")
    protected String DNI;

    protected String name;

    protected Integer age;
}
