package co.com.randomapi.web.controller;

import co.com.randomapi.domain.dto.StudentDTO;
import co.com.randomapi.domain.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController implements BasicController<StudentDTO, Long> {
    private final StudentService service;

    @Override
    @GetMapping
    public List<StudentDTO> getAll() {
        return this.service.findAll();
    }

    @Override
    @GetMapping("{id}")
    public StudentDTO getById(@PathVariable("id") Long id) {
        return this.service.findById(id).orElseThrow();
    }

    @Override
    @PostMapping
    public StudentDTO post(@RequestBody StudentDTO dto) {
        return this.service.create(dto);
    }

    @Override
    @PutMapping
    public StudentDTO update(@RequestBody StudentDTO changes) {
        return this.service.update(changes);
    }

    @Override
    @DeleteMapping("{id}")
    public StudentDTO delete(@PathVariable("id") Long id) {
        return this.service.delete(id);
    }
}
