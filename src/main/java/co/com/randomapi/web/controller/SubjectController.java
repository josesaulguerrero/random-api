package co.com.randomapi.web.controller;

import co.com.randomapi.domain.dto.SubjectDTO;
import co.com.randomapi.domain.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjects")
@AllArgsConstructor
public class SubjectController implements BasicController<SubjectDTO, Long> {
    private final SubjectService service;

    @Override
    @GetMapping
    public List<SubjectDTO> getAll() {
        return this.service.findAll();
    }

    @Override
    @GetMapping("{id}")
    public SubjectDTO getById(@PathVariable("id") Long id) {
        return this.service.findById(id).orElseThrow();
    }

    @Override
    @PostMapping
    public SubjectDTO post(@RequestBody  SubjectDTO dto) {
        return this.service.create(dto);
    }

    @Override
    @PutMapping
    public SubjectDTO update(@RequestBody SubjectDTO changes) {
        return this.service.update(changes);
    }

    @Override
    @DeleteMapping("{id}")
    public SubjectDTO delete(@PathVariable("id") Long id) {
        return this.service.delete(id);
    }
}
