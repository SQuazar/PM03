package net.quazar.exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tour_requests")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TourRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Integer id;
    private @Column(nullable = false) String client;
    private @Column(nullable = false) String clientPhoneNumber;
    private @Column(nullable = false) double tourSum;
    private @Column(nullable = false) String tourDirection;
    private @Column(nullable = false) LocalDate tourStart;
    private @Column(nullable = false) LocalDate tourEnd;
    private @Column(nullable = false) String status;
}
