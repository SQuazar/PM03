package net.quazar.exam.util.mapper;

import net.quazar.exam.entity.TourRequest;
import net.quazar.exam.entity.dto.TourRequestDto;
import net.quazar.exam.util.DtoMapper;
import org.springframework.stereotype.Component;

@Component
public class TourRequestMapper implements DtoMapper<TourRequest, TourRequestDto> {
    @Override
    public TourRequest mapFrom(TourRequestDto tourRequestDto) {
        return TourRequest.builder()
                .id(tourRequestDto.getId())
                .client(tourRequestDto.getClient())
                .clientPhoneNumber(tourRequestDto.getPhoneNumber())
                .tourSum(tourRequestDto.getTourSum())
                .tourDirection(tourRequestDto.getTourDirection())
                .tourStart(tourRequestDto.getTourStart())
                .tourEnd(tourRequestDto.getTourEnd())
                .status(tourRequestDto.getStatus())
                .build();
    }

    @Override
    public TourRequestDto mapTo(TourRequest tourRequest) {
        return TourRequestDto.builder()
                .id(tourRequest.getId())
                .client(tourRequest.getClient())
                .phoneNumber(tourRequest.getClientPhoneNumber())
                .tourSum(tourRequest.getTourSum())
                .tourDirection(tourRequest.getTourDirection())
                .tourStart(tourRequest.getTourStart())
                .tourEnd(tourRequest.getTourEnd())
                .status(tourRequest.getStatus())
                .build();
    }
}
