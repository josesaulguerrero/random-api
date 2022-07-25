package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.SubjectDTO;
import co.com.randomapi.persistence.entity.Subject;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { StudentMapper.class, ProfessorMapper.class })
public interface SubjectMapper extends BasicMapper<Subject, SubjectDTO> {
    @Override
    public abstract Subject DTOToEntity(SubjectDTO dto);

    @Override
    @InheritInverseConfiguration
    public abstract SubjectDTO entityToDTO(Subject entity);
    @Override
    public abstract List<SubjectDTO> entitiesToDTOs(List<Subject> entities);
}
