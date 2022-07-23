package co.com.randomapi.persistence.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Person<T> {
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
