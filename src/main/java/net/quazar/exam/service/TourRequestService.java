package net.quazar.exam.service;

import net.quazar.exam.entity.dto.TourRequestDto;

import java.util.List;

public interface TourRequestService {
    TourRequestDto getById(int id);
    List<TourRequestDto> findAll();
    void delete(TourRequestDto request);
    void deleteById(int id);
    TourRequestDto save(TourRequestDto request);
}
