package net.quazar.exam.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TourRequestDto {
    private Integer id;
    private String client;
    private @JsonProperty("phone_number") String phoneNumber;
    private @JsonProperty("tour_sum") double tourSum;
    private @JsonProperty("tour_direction") String tourDirection;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private @JsonProperty("tour_start") LocalDate tourStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private @JsonProperty("tour_end") LocalDate tourEnd;
    private String status;
}
