package net.quazar.exam.service.impl;

import lombok.AllArgsConstructor;
import net.quazar.exam.entity.TourRequest;
import net.quazar.exam.entity.dto.TourRequestDto;
import net.quazar.exam.exception.TourRequestNotFoundException;
import net.quazar.exam.repository.TourRequestRepository;
import net.quazar.exam.service.TourRequestService;
import net.quazar.exam.util.mapper.TourRequestMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TourRequestServiceImpl implements TourRequestService {
    private final TourRequestRepository repository;
    private final TourRequestMapper mapper;

    @Override
    public TourRequestDto getById(int id) {
        return mapper.mapTo(repository.findById(id).orElseThrow(() ->
                new TourRequestNotFoundException(String.format("Tour with id %d isn't found", id))));
    }

    @Override
    public List<TourRequestDto> findAll() {
        return repository.findAll().stream().map(mapper::mapTo).toList();
    }

    @Override
    public List<TourRequestDto> findAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest).map(mapper::mapTo).stream().toList();
    }

    @Override
    public List<TourRequestDto> findByStatus(String status) {
        return repository.findAllByStatus(status).stream().map(mapper::mapTo).toList();
    }

    @Override
    public void delete(TourRequestDto request) {
        deleteById(request.getId());
    }

    @Override
    public void deleteById(int id) {
        repository.delete(repository.findById(id).orElseThrow(() ->
                new TourRequestNotFoundException(String.format("Tour with id %d isn't found", id))));
    }

    @Override
    public TourRequestDto save(TourRequestDto request) {
        TourRequest tourRequest = mapper.mapFrom(request);
        return mapper.mapTo(repository.save(tourRequest));
    }
}
