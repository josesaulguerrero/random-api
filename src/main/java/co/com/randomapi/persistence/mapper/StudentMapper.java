package co.com.randomapi.persistence.mapper;

import co.com.randomapi.domain.dto.StudentDTO;
import co.com.randomapi.persistence.entity.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BasicMapper<Student, StudentDTO> {
    @Override
    @Mapping(source = "dni", target = "DNI")
    Student DTOToEntity(StudentDTO dto);

    @Override
    @InheritInverseConfiguration
    StudentDTO entityToDTO(Student entity);

    @Override
    List<StudentDTO> entitiesToDTOs(List<Student> entities);
}
