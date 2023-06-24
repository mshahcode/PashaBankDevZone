import com.example.demo.controller.EmployeeController
import com.example.demo.dto.EmployeeAllInfoDTO
import com.example.demo.dto.NewEmployeeDTO
import com.example.demo.repository.EmployeeRepository
import com.example.demo.service.EmployeeService
import com.example.demo.service.SalaryService
import org.springframework.data.domain.PageImpl
import spock.lang.Specification

class EmployeeControllerTest extends Specification {

    private EmployeeService employeeService = Mock(EmployeeService);

    private EmployeeController employeeController = new EmployeeController(employeeService);

    def "AddEmployeeAllInfo"() {
        given:
        NewEmployeeDTO newEmployeeDTO = new NewEmployeeDTO()

        when:
        this.employeeController.addEmployeeAllInfo(newEmployeeDTO)

        then:
        1 * this.employeeService.addNewEmployeeAllInfo(newEmployeeDTO);
    }

    def "GetAllEmployees"() {
        given:

        def page = new PageImpl<EmployeeAllInfoDTO>([])

        when:
        def result = this.employeeController.getAllEmployees(0, 10)

        then:
        1 * this.employeeService.getEmployeePage(0, 10) >> page
        result == page
    }

    def "GetEmployeeAllInfoById"() {
        given:
        EmployeeAllInfoDTO employeeAllInfoDTO = new EmployeeAllInfoDTO()

        when:
        def result = this.employeeController.getEmployeeAllInfoById(1)

        then:
        1 * this.employeeService.getEmployeeById(1) >> EmployeeAllInfoDTO
        result == employeeAllInfoDTO
    }

    def "AddEmployee"() {
    }
}
