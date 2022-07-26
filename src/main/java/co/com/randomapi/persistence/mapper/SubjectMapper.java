package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.SubjectDTO;
import co.com.randomapi.persistence.entity.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { StudentMapper.class, ProfessorMapper.class })
public interface SubjectMapper extends BasicMapper<Subject, SubjectDTO> {
    @Override
    Subject DTOToEntity(SubjectDTO dto);

    @Override
    SubjectDTO entityToDTO(Subject entity);
    @Override
    List<SubjectDTO> entitiesToDTOs(List<Subject> entities);
}
