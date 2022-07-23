package co.com.randomapi.persistence.repository;

import co.com.randomapi.persistence.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
