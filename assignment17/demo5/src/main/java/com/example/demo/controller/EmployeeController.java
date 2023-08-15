    package com.example.demo.controller;


    import com.example.demo.dto.EmployeeAllInfoDTO;
    import com.example.demo.dto.EmployeeDTO;
    import com.example.demo.dto.NewEmployeeDTO;
    import com.example.demo.entity.Employee;
    import com.example.demo.service.EmployeeService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.data.domain.Page;
    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.client.RestTemplate;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/employees")
    public class EmployeeController {

        private final EmployeeService employeeService;
        private final String BASE_URL = "http://localhost:8080"; // Replace with your actual base URL
        private final RestTemplate restTemplate = new RestTemplate();




        @PostMapping("/addAll")
        @ResponseStatus(HttpStatus.CREATED)
        public void addEmployeeAllInfo(@RequestBody NewEmployeeDTO newEmployeeDTO) {
            this.employeeService.addNewEmployeeAllInfo(newEmployeeDTO);
         //  restTemplate.postForObject(BASE_URL + "/employees/addAll", newEmployeeDTO, Void.class);

        }

        @GetMapping()
        @ResponseStatus(HttpStatus.OK)
        public Page<EmployeeAllInfoDTO> getAllEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
            return this.employeeService.getEmployeePage(page,size);
//            ResponseEntity<Page<EmployeeAllInfoDTO>> response = restTemplate.exchange(
//                    BASE_URL + "/employees?page=" + page + "&size=" + size,
//                    HttpMethod.GET,
//                    HttpEntity.EMPTY,
//                    ParameterizedTypeReference.forType(Page.class)
//            );
//            return response.getBody();
        }

        @GetMapping("/{id}")
        public EmployeeAllInfoDTO getEmployeeAllInfoById(@PathVariable Long id) {
            return this.employeeService.getEmployeeById(id);
//            ResponseEntity<EmployeeAllInfoDTO> response = restTemplate.getForEntity(BASE_URL + "/employees/" + id, EmployeeAllInfoDTO.class);
//            return response.getBody();
        }

        @PostMapping("/add")
        @ResponseStatus(HttpStatus.CREATED)
        public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
            this.employeeService.addEmployee(employeeDTO);
        }
    }
