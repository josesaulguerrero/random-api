package co.com.randomapi.domain.service;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.persistence.entity.Professor;
import co.com.randomapi.persistence.mapper.ProfessorMapper;
import co.com.randomapi.persistence.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<ProfessorDTO> findById(Long id) {
        Professor professor = repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The given id doesn't belong to any record."));
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
    public ProfessorDTO update(ProfessorDTO updatedDto) {
        Long dtoId = updatedDto.getId();
        if (dtoId == null) {
            throw new IllegalArgumentException("The supplied DTO doesn't have an id.");
        }
        return this
                .findById(updatedDto.getId())
                .orElseThrow();
    }

    @Override
    public ProfessorDTO delete(Long id) {
        return null;
    }
}
