package co.com.randomapi.domain.service;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.persistence.entity.Professor;
import co.com.randomapi.persistence.mapper.ProfessorMapper;
import co.com.randomapi.persistence.repository.ProfessorRepository;
import co.com.randomapi.utils.ExceptionBuilder;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@AllArgsConstructor
@Service
public class ProfessorService implements BasicService<ProfessorDTO, Long> {
    private final ProfessorMapper mapper;
    private final ProfessorRepository repository;

    @Override
    public List<ProfessorDTO> findAll() {
        List<Professor> professors = repository.findAll();
        return mapper.entitiesToDTOs(professors);
    }

    private void validateIdIsNotEmpty(Long id) {
        if(id == null) {
            throw new ExceptionBuilder(IllegalArgumentException.class)
                    .developerMessage("You cannot pass an empty id.")
                    .build();
        }
    }

    private void validateIdExists(Long id) {
        if(!this.repository.existsById(id)) {
            throw new ExceptionBuilder(IllegalArgumentException.class)
                    .developerMessage("The given id doesn't belong to any record.")
                    .build();
        }
    }

    @Override
    public Optional<ProfessorDTO> findById(Long id) {
        validateIdIsNotEmpty(id);
        validateIdExists(id);
        Professor professor = repository
                .findById(id)
                .orElseThrow();
        ProfessorDTO dto = mapper.entityToDTO(professor);
        return Optional.of(dto);
    }

    @Override
    public ProfessorDTO create(ProfessorDTO dto) {
        Professor entity = repository.save(
                mapper.DTOToEntity(dto)
        );
        return mapper.entityToDTO(entity);
    }

    @Override
    public ProfessorDTO update(ProfessorDTO changes) {
        validateIdIsNotEmpty(changes.getId());
        validateIdExists(changes.getId());
        Professor entityFromDTO = mapper.DTOToEntity(changes);
        Professor updatedEntity = this.repository.save(entityFromDTO);
        return mapper.entityToDTO(updatedEntity);
    }

    @Override
    public ProfessorDTO delete(Long id) {
        validateIdIsNotEmpty(id);
        validateIdExists(id);
        ProfessorDTO dto = this.findById(id).orElseThrow();
        this.repository.deleteById(id);
        return dto;
    }
}
