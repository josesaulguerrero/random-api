package co.com.randomapi.persistence.entity;

import lombok.*;

import javax.persistence.MappedSuperclass;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(value = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PROTECTED)
@ToString
@MappedSuperclass
public abstract class Person {
    protected String DNI;
    protected String name;
    protected Integer age;
}
