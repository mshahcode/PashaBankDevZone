package com.example.carsproject.Mapper;

import com.example.carsproject.dto.CarsDTO;
import com.example.carsproject.dto.NewCarDTO;
import com.example.carsproject.entity.CarsEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class CarsMapper {

    public CarsEntity mapCarsDtoToCarsEntity(CarsDTO carsDTO) {
        return CarsEntity.builder()
                .carId(carsDTO.getCarId())
                .carModel(carsDTO.getCarModel())
                .carYear(carsDTO.getCarYear())
                .createdAt(carsDTO.getCreatedAt())
                .updatedAt(carsDTO.getUpdatedAt())
                .build();
    }

    public CarsEntity mapNewCarsDtoToCarsEntity(NewCarDTO newCarDTO) {
        return CarsEntity.builder()
                .carModel(newCarDTO.getCarModel())
                .carYear(newCarDTO.getCarYear())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public CarsDTO mapCarsEntityToCarsDto(CarsEntity carsEntity) {
        return CarsDTO.builder()
                .carId(carsEntity.getCarId())
                .carModel(carsEntity.getCarModel())
                .carYear(carsEntity.getCarYear())
                .createdAt(carsEntity.getCreatedAt())
                .updatedAt(carsEntity.getUpdatedAt())
                .build();
    }
}
