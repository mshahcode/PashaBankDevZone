package com.example.carsproject.Controller;

import com.example.carsproject.Service.CarsService;
import com.example.carsproject.dto.CarsDTO;
import com.example.carsproject.dto.CarsFilteringDTO;
import com.example.carsproject.dto.NewCarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarsController {

    private final CarsService carsService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Page<CarsDTO> getAllCars(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return this.carsService.getAllCars(page, size);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    Page<CarsDTO> getFilteredCars(@RequestBody CarsFilteringDTO carsFilteringDTO) {
        return this.carsService.getFilteredCars(carsFilteringDTO);
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    CarsDTO getCarById(@PathVariable Long id) throws Exception {
        return this.carsService.getCarById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addNewCar(@RequestBody NewCarDTO newCarDTO) {
        this.carsService.addNewCar(newCarDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateCar(@PathVariable Long id, @RequestBody NewCarDTO updatedCar) throws Exception {
        this.carsService.updateCar(id, updatedCar);
    }
}
