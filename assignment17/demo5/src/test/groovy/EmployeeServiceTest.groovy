import com.example.demo.dto.EmployeeAllInfoDTO
import com.example.demo.dto.EmployeeDTO
import com.example.demo.dto.NewEmployeeDTO
import com.example.demo.entity.Contact
import com.example.demo.entity.Employee
import com.example.demo.entity.Salary
import com.example.demo.mapper.EmployeeMapper
import com.example.demo.mapper.ProductMapper
import com.example.demo.repository.EmployeeRepository
import com.example.demo.repository.ProductRepository
import com.example.demo.service.EmployeeService
import com.example.demo.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import spock.lang.Specification

import java.awt.print.Pageable
import java.time.LocalDate

class EmployeeServiceTest extends Specification {
    private EmployeeMapper employeeMapper = Mock(EmployeeMapper);
    private EmployeeRepository employeeRepository = Mock(EmployeeRepository);
    private EmployeeService employeeService = new EmployeeService(employeeMapper, employeeRepository);


    def "AddNewEmployeeAllInfo"() {
        given:
        NewEmployeeDTO newEmployeeDTO = new NewEmployeeDTO();
        Employee employee = new Employee();
        Contact contact = new Contact(); // Initialize contact field
        employee.setContact(contact); // Set contact on employee
        Salary salary = new Salary();
        employee.setSalary(salary)

        when:
        this.employeeService.addNewEmployeeAllInfo(newEmployeeDTO);

        then:
        1 * employeeMapper.mapNewEmployeeDtoToEmployee(newEmployeeDTO) >> employee
        1 * employeeRepository.save(employee);
    }

    def "GetEmployeePage"() {
        given:
        def size = 10
        def page = 0
        org.springframework.data.domain.Pageable pageable = PageRequest.of(page, size);
        List<Employee> employees = [new Employee(), new Employee()]
        Page<Employee> employeePage = new PageImpl<>(employees, pageable, employees.size().toLong())

        when:
        Page<EmployeeAllInfoDTO> result = this.employeeService.getEmployeePage(page,size);

        then:
        1 * this.employeeRepository.findAllBy(pageable) >> employeePage
        2 * this.employeeMapper.mapEmployeetoEmployeeAllInfoDto(_)
        result.getTotalElements() == employeePage.getTotalElements()
    }

    def "GetEmployeeById"() {
        given:
        Employee employee = new Employee()
        Long id = 1L;
        employee.setId(id)
        EmployeeAllInfoDTO employeeAllInfoDTO = new EmployeeAllInfoDTO();

        when:
        def result = this.employeeService.getEmployeeById(id)

        then:
        1 * this.employeeRepository.findById(id) >> Optional.of(employee)
        1 * this.employeeMapper.mapEmployeetoEmployeeAllInfoDto(employee) >> employeeAllInfoDTO
        result == employeeAllInfoDTO

    }

    def "AddEmployee"() {
        given:
        EmployeeDTO employeeDTO = new EmployeeDTO()
        employeeDTO.setBirthDate(LocalDate.of(2020,5,5))
        employeeDTO.setFirst_name("Mika")
        employeeDTO.setLast_name("Shah")

        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.of(2020,5,5))
        employee.setFirst_name("Mika")
        employee.setLast_name("Shah")

        when:
        this.employeeService.addEmployee(employeeDTO)

        then:
        1 * this.employeeMapper.mapEmployeeDtoToEmployee(employeeDTO) >> employee
        1 * this.employeeRepository.save(employee)
    }

    def "GetByFullName"() {
        given:
        def fName = "Mika"
        def lName = "Mika"

        Employee employee = new Employee()
        employee.setFirst_name(fName)
        employee.setLast_name(lName)

        when:
        def result = this.employeeService.getByFullName(fName,lName)

        then:
        1 * this.employeeRepository.getByFullName(fName,lName) >> employee
        result.getFirst_name() == result.getFirst_name()
        result.getLast_name() == result.getLast_name()

    }
}
