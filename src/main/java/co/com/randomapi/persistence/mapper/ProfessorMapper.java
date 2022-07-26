package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.persistence.entity.Professor;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    @Mapping(source = "DNI", target = "dni")
    ProfessorDTO entityToDTO(Professor entity);

    List<ProfessorDTO> entitiesToDTOs(List<Professor> entities);

    @InheritInverseConfiguration
    @Mapping(target = "subjectsInCharge", ignore = true)
    Professor DTOToEntity(ProfessorDTO dto);
}
