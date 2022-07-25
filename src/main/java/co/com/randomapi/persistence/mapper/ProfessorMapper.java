package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.persistence.entity.Professor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorMapper extends BasicMapper<Professor, ProfessorDTO> {
    @Override
    @Mappings(value = {
            @Mapping(source = "dni", target = "DNI"),
    })
    public abstract Professor DTOToEntity(ProfessorDTO dto);

    @Override
    @InheritInverseConfiguration
    public abstract ProfessorDTO entityToDTO(Professor entity);

    @Override
    public abstract List<ProfessorDTO> entitiesToDTOs(List<Professor> entities);
}
