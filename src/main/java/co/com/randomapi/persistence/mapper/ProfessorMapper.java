package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.persistence.entity.Professor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { SubjectMapper.class })
public abstract class ProfessorMapper implements BasicMapper<Professor, ProfessorDTO> {
    @Override
    @Mappings(value = {
            @Mapping(source = "id", target = "Id"),
            @Mapping(source = "dni", target = "DNI"),
    })
    public abstract Professor DTOToEntity(ProfessorDTO dto);

    @Override
    @InheritInverseConfiguration
    public abstract ProfessorDTO entityToDTO(Professor entity);
}
