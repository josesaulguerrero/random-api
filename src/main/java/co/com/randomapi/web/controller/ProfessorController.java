package co.com.randomapi.web.controller;

import co.com.randomapi.domain.dto.ProfessorDTO;
import co.com.randomapi.domain.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "professors")
@AllArgsConstructor
public class ProfessorController implements BasicController<ProfessorDTO, Long> {
    private final ProfessorService service;

    @Override
    @GetMapping
    public List<ProfessorDTO> getAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("{id}")
    public ProfessorDTO getById(@PathVariable("id") Long id) {
        return service.findById(id).orElseThrow();
    }

    @Override
    @PostMapping
    public ProfessorDTO post(@RequestBody ProfessorDTO dto) {
        return service.create(dto);
    }

    @Override
    @PatchMapping
    public ProfessorDTO update(@RequestBody ProfessorDTO changes) {
        return this.service.update(changes);
    }

    @Override
    @DeleteMapping("{id}")
    public ProfessorDTO delete(@PathVariable("id") Long id) {
        return this.service.delete(id);
    }
}
