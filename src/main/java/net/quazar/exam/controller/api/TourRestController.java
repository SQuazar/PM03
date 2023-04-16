package net.quazar.exam.controller.api;

import lombok.AllArgsConstructor;
import net.quazar.exam.entity.dto.TourRequestDto;
import net.quazar.exam.service.TourRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@AllArgsConstructor
public class TourRestController {
    private final TourRequestService service;

    @GetMapping("/")
    public List<TourRequestDto> getAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public TourRequestDto create(@RequestBody TourRequestDto requestDto) {
        return service.save(requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}
