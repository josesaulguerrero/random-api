package co.com.randomapi.persistence.repository;

import co.com.randomapi.persistence.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
