import com.example.demo.dto.EmployeeAllInfoDTO
import com.example.demo.dto.EmployeeDTO
import com.example.demo.dto.SalaryDTO
import com.example.demo.entity.Employee
import com.example.demo.entity.Salary
import com.example.demo.mapper.EmployeeMapper
import spock.lang.Specification
import java.time.LocalDate

class EmployeeMapperTest extends Specification {
    def "MapEmployeeDtoToEmployee"() {
        given:
        EmployeeDTO employeeDTO = new EmployeeDTO("Mika", "Shah", LocalDate.of(2002, 5, 5))

        when:
        Employee employee = EmployeeMapper.INSTANCE.mapEmployeeDtoToEmployee(employeeDTO)

        then:
        employee.first_name == "Mika"
        employee.last_name == "Shah"
        employee.birthDate == LocalDate.of(2002, 5, 5)
    }

//    def "MapEmployeetoEmployeeAllInfoDto"() {
//
//    }

    def "MapSalaryToSalaryDto"() {
        given:
        Salary salary = new Salary(1L,40.24,"AZN",null);

        when:
        SalaryDTO salaryDTO = EmployeeMapper.INSTANCE.mapSalaryToSalaryDto(salary);

        then:
        salaryDTO.amount == 40.24
        salaryDTO.currency == "AZN"
    }

//    def "MapSalaryDtoToSalary"() {
//    }
//
//    def "MapContactToContactDto"() {
//    }
//
//    def "MapContactDtoToContact"() {
//    }
//
//    def "MapNewEmployeeDtoToEmployee"() {
//    }
//
//    def "MapProjectDtoToProject"() {
//    }
//
//    def "MapProjectToProjectDto"() {
//    }
}
