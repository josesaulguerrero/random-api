package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.SubjectDTO;
import co.com.randomapi.persistence.entity.Subject;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { StudentMapper.class, ProfessorMapper.class })
public abstract class SubjectMapper implements BasicMapper<Subject, SubjectDTO> {
    @Override
    @Mapping(source = "id", target = "Id")
    public abstract Subject DTOToEntity(SubjectDTO dto);

    @Override
    @InheritInverseConfiguration
    public abstract SubjectDTO entityToDTO(Subject entity);
}
