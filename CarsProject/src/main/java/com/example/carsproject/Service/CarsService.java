package com.example.carsproject.Service;

import com.example.carsproject.Mapper.CarsMapper;
import com.example.carsproject.Repository.CarsRepository;
import com.example.carsproject.dto.CarsDTO;
import com.example.carsproject.dto.CarsFilteringDTO;
import com.example.carsproject.dto.NewCarDTO;
import com.example.carsproject.entity.CarsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarsService {

    private final CarsRepository carsRepository;
    private final CarsMapper carsMapper;

    public Page<CarsDTO> getAllCars(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var allCars = this.carsRepository.findAllBy(pageable);
        return allCars.map(carsMapper::mapCarsEntityToCarsDto);
    }

    public Page<CarsDTO> getFilteredCars(CarsFilteringDTO filteringDTO) {
        Pageable pageable = PageRequest.of(filteringDTO.getPage(), filteringDTO.getSize());
        var filteredCars = this.carsRepository.getFilteredCars(pageable, filteringDTO.getCarModel()
                , filteringDTO.getCarYear(), filteringDTO.getCreatedAt());
        return filteredCars.map(carsMapper::mapCarsEntityToCarsDto);
    }

    public CarsDTO getCarById(Long id) throws Exception {
        return this.carsRepository.findById(id).map(carsMapper::mapCarsEntityToCarsDto)
                .orElseThrow(() -> new Exception("Car not found - " + id));
    }

    public void addNewCar(NewCarDTO newCarDTO){
        CarsEntity newCar = this.carsMapper.mapNewCarsDtoToCarsEntity(newCarDTO);
        this.carsRepository.save(newCar);
        System.out.println("Added a new successfully!");

    }

    public void updateCar(Long id, NewCarDTO updatedCar) throws Exception {
        Optional<CarsEntity> optionalCar = this.carsRepository.findById(id);
        if(optionalCar.isPresent()){
            CarsEntity car = optionalCar.get();
            car.setCarModel(updatedCar.getCarModel());
            car.setCarYear(updatedCar.getCarYear());
            car.setUpdatedAt(LocalDateTime.now());
            this.carsRepository.save(car);
            System.out.println("Updated successfully!");
        }else{
            throw new Exception("Car not found to update with ID: " + id);
        }
    }
}
