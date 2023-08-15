import com.example.demo.dto.SalaryDTO
import com.example.demo.entity.Employee
import com.example.demo.entity.Salary
import com.example.demo.mapper.SalaryMapper
import com.example.demo.repository.EmployeeRepository
import com.example.demo.repository.SalaryRepository
import com.example.demo.service.SalaryService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.mock.DetachedMockFactory

@SpringBootTest
class SalaryServiceTest extends Specification {
    private SalaryRepository salaryRepository = Mock(SalaryRepository);
    private EmployeeRepository employeeRepository = Mock(EmployeeRepository);
    private SalaryMapper salaryMapper = Mock(SalaryMapper);

    private SalaryService salaryService = new SalaryService(salaryRepository, employeeRepository, salaryMapper)

    def "AddSalary"() {
        given:
        def salaryDTO = new SalaryDTO()
        def employeeId = 1L

        def employee = new Employee()
        employee.setId(employeeId)

        def salary = new Salary()

        when:
        salaryService.addSalary(salaryDTO, employeeId)

        then:
        1 * employeeRepository.findById(employeeId) >> Optional.of(employee)
        1 * salaryMapper.mapSalaryDtoToSalary(salaryDTO) >> salary
        1 * salaryRepository.save(salary)
    }

    def "AddSalary throws exception when employee is not found"() {
        given:
        def salaryDTO = new SalaryDTO()
        def employeeId = 1L

        when:
        salaryService.addSalary(salaryDTO, employeeId)

        then:
        1 * employeeRepository.findById(employeeId) >> Optional.empty()
        0 * salaryMapper.mapSalaryDtoToSalary(_)
        0 * salaryRepository.save(_)
        thrown(Exception)
    }

    def "GetAllSalaries"() {
        given:
        def expectedSalaries = [new Salary(), new Salary()]

        when:
        List<Salary> salaries = salaryService.getAllSalaries()

        then:
        1 * salaryRepository.findAll() >> expectedSalaries
        salaries.size() == expectedSalaries.size()
    }

    def "deleteSalary"(){
        given:
        Salary salary = new Salary();
        Employee employee = new Employee()
        employee.setSalary(salary)
        salary.setEmployee(employee)
        Long id = 1L
        salary.setId(id)

        when:
        this.salaryService.deleteSalary(id)

        then:
        1 * this.salaryRepository.findById(id) >> Optional.of(salary)
        1 * this.employeeRepository.save(employee)
        employee.getSalary() == null
    }

}
