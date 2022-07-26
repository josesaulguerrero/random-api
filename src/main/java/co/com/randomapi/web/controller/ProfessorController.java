package co.com.randomapi.web.controller;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.domain.service.ProfessorService;
import co.com.randomapi.persistence.entity.Professor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "professors")
@AllArgsConstructor
public class ProfessorController implements BasicController<ProfessorDTO, Long> {
    private final ProfessorService service;

    @GetMapping
    @Override
    public List<ProfessorDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @Override
    public ProfessorDTO getById(@PathVariable("id") Long id) {
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    @Override
    public ProfessorDTO post(@RequestBody ProfessorDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    @Override
    public ProfessorDTO update(@RequestBody ProfessorDTO changes) {
        return this.service.update(changes);
    }

    @DeleteMapping("{id}")
    @Override
    public ProfessorDTO delete(@PathVariable("id") Long id) {
        return this.service.delete(id);
    }
}
