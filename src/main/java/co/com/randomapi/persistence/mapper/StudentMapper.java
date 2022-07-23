package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.StudentDTO;
import co.com.randomapi.persistence.entity.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { SubjectMapper.class })
public abstract class StudentMapper implements BasicMapper<Student, StudentDTO> {
    @Override
    @Mappings(value = {
            @Mapping(source = "id", target = "Id"),
            @Mapping(source = "dni", target = "DNI")
    })
    public abstract Student DTOToEntity(StudentDTO dto);

    @Override
    @InheritInverseConfiguration
    public abstract StudentDTO entityToDTO(Student entity);
}
