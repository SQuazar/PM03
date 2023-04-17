package net.quazar.exam.repository;

import net.quazar.exam.entity.TourRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRequestRepository extends JpaRepository<TourRequest, Integer> {
    List<TourRequest> findAllByStatus(String status);
}
