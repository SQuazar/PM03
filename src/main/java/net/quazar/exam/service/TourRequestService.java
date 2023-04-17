package net.quazar.exam.service;

import net.quazar.exam.entity.dto.TourRequestDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface TourRequestService {
    TourRequestDto getById(int id);
    List<TourRequestDto> findAll();
    List<TourRequestDto> findAll(PageRequest pageRequest);
    List<TourRequestDto> findByStatus(String status);
    void delete(TourRequestDto request);
    void deleteById(int id);
    TourRequestDto save(TourRequestDto request);
}
