package co.com.randomapi.domain.service;

import co.com.randomapi.domain.dto.StudentDTO;
import co.com.randomapi.persistence.entity.Student;
import co.com.randomapi.persistence.mapper.StudentMapper;
import co.com.randomapi.persistence.repository.StudentRepository;
import co.com.randomapi.utils.ExceptionBuilder;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class StudentService implements BasicService<StudentDTO, Long> {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public List<StudentDTO> findAll() {
        List<Student> entities = this.repository.findAll();
        return mapper.entitiesToDTOs(entities);
    }

    private void validateIdIsNotEmpty(Long id) {
        if (id == null) {
            throw new ExceptionBuilder(IllegalArgumentException.class)
                    .developerMessage("You cannot pass an empty id.")
                    .build();
        }
    }

    private void validateIdExists(Long id) {
        if (!this.repository.existsById(id)) {
            throw new ExceptionBuilder(IllegalArgumentException.class)
                    .developerMessage("The given id doesn't belong to any record.")
                    .build();
        }
    }

    @Override
    public Optional<StudentDTO> findById(Long id) {
        validateIdIsNotEmpty(id);
        validateIdExists(id);
        Student entity = repository
                .findById(id)
                .orElseThrow();
        StudentDTO dto = mapper.entityToDTO(entity);
        return Optional.of(dto);
    }

    @Override
    public StudentDTO create(StudentDTO dto) {
        Student entity = repository.save(
                mapper.DTOToEntity(dto)
        );
        return mapper.entityToDTO(entity);
    }

    @Override
    public StudentDTO update(StudentDTO changes) {
        validateIdIsNotEmpty(changes.getId());
        validateIdExists(changes.getId());
        Student entityFromDTO = mapper.DTOToEntity(changes);
        Student updatedEntity = this.repository.save(entityFromDTO);
        return mapper.entityToDTO(updatedEntity);
    }

    @Override
    public StudentDTO delete(Long id) {
        validateIdIsNotEmpty(id);
        validateIdExists(id);
        StudentDTO dto = this.findById(id).orElseThrow();
        this.repository.deleteById(id);
        return dto;
    }
}
