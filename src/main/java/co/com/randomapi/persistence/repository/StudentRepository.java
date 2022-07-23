package co.com.randomapi.persistence.repository;

import co.com.randomapi.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
