package com.example.carsproject.Repository;

import com.example.carsproject.entity.CarsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface CarsRepository extends JpaRepository<CarsEntity, Long> {

    Page<CarsEntity> findAllBy(Pageable pageable);

    @Query(value = "SELECT c FROM CarsEntity c WHERE " +
            "(:model is null or c.carModel = :model) and " +
            "(:year is null or c.carYear = :year) and " +
            "(cast(:date as date) is null or date_trunc('second', c.createdAt) = :date)")
    Page<CarsEntity> getFilteredCars(Pageable pageable, @Param("model") String model, @Param("year") String year, @Param("date") LocalDateTime date);
}
