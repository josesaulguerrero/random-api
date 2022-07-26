package co.com.randomapi.domain.service;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.domain.dto.StudentDTO;
import co.com.randomapi.domain.dto.SubjectDTO;
import co.com.randomapi.persistence.entity.Subject;
import co.com.randomapi.persistence.mapper.SubjectMapper;
import co.com.randomapi.persistence.repository.SubjectRepository;
import co.com.randomapi.utils.ExceptionBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService implements BasicService<SubjectDTO, Long> {
    private final SubjectRepository repository;
    private final SubjectMapper mapper;

    @Override
    public List<SubjectDTO> findAll() {
        List<Subject> entities = this.repository.findAll();
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
    public Optional<SubjectDTO> findById(Long id) {
        validateIdIsNotEmpty(id);
        validateIdExists(id);
        Subject entity = repository
                .findById(id)
                .orElseThrow();
        SubjectDTO dto = mapper.entityToDTO(entity);
        return Optional.of(dto);
    }

    @Override
    public SubjectDTO create(SubjectDTO dto) {
        Subject entity = repository.save(
                mapper.DTOToEntity(dto)
        );
        return mapper.entityToDTO(entity);
    }

    @Override
    public SubjectDTO update(SubjectDTO changes) {
        validateIdIsNotEmpty(changes.getId());
        validateIdExists(changes.getId());
        Subject entityFromDTO = mapper.DTOToEntity(changes);
        Subject updatedEntity = this.repository.save(entityFromDTO);
        return mapper.entityToDTO(updatedEntity);
    }

    public SubjectDTO assignProfessor(Long subjectId, ProfessorDTO dto) {
        SubjectDTO subject = this.findById(subjectId).orElseThrow();
        subject.setAssignedProfessor(dto);
        return this.update(subject);
    }

    public SubjectDTO suscribeStudent(Long subjectId, StudentDTO dto) {
        SubjectDTO subject = this.findById(subjectId).orElseThrow();
        subject.suscribeStudent(dto);
        return this.update(subject);
    }

    @Override
    public SubjectDTO delete(Long id) {
        validateIdIsNotEmpty(id);
        validateIdExists(id);
        SubjectDTO dto = this.findById(id).orElseThrow();
        this.repository.deleteById(id);
        return dto;
    }
}

