package co.com.randomapi.domain.dto;

import co.com.randomapi.persistence.entity.Subject;

import java.util.Set;

public class StudentDTO {
    private long id;
    private String name;
    private int age;
    private String dni;
    private Set<Subject> subscribedTo;
}
