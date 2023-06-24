import com.example.demo.dto.NewProductDTO
import com.example.demo.dto.ProductUpdateDto
import com.example.demo.entity.Employee
import com.example.demo.entity.Product
import com.example.demo.mapper.ProductMapper
import com.example.demo.mapper.SalaryMapper
import com.example.demo.repository.EmployeeRepository
import com.example.demo.repository.ProductRepository
import com.example.demo.repository.SalaryRepository
import com.example.demo.service.EmployeeService
import com.example.demo.service.ProductService
import com.example.demo.service.SalaryService
import spock.lang.Specification

class ProductServiceTest extends Specification {

    private ProductRepository productRepository = Mock(ProductRepository);
    private EmployeeService employeeService = Mock(EmployeeService);
    private ProductMapper productMapper = Mock(ProductMapper);
    private EmployeeRepository employeeRepository = Mock(EmployeeRepository);

    private ProductService productService = new ProductService(productRepository, productMapper, employeeService,employeeRepository);

    def "AddNewProduct"() {
        given:
        NewProductDTO newProductDTO = new NewProductDTO();
        Employee employee = new Employee();
        Product product = new Product();

        when:
        this.productService.addNewProduct(newProductDTO);

        then:
        1 * this.employeeService.getByFullName(_,_) >> employee
        1 * this.productMapper.mapNewProductDtoToProduct(newProductDTO) >> product
        1 * this.productRepository.save(_)
    }

    def "UpdateProduct"() {
        given:
        ProductUpdateDto productUpdateDto = new ProductUpdateDto();
        productUpdateDto.setName("Iphone 13 Pro Max");
        def product_id = 1L;
        Product product = new Product(1L,"Iphone 14 Pro Max 256GB", null);

        when:
        this.productService.updateProduct(productUpdateDto,product_id);

        then:
        1 * this.productRepository.findById(product_id) >> Optional.of(product)
        1 * this.productRepository.save(product)
        product.getName() == productUpdateDto.getName()
    }

    def "deletion of product"(){
        given:
        def id = 1L
        def employee = new Employee()
        def product = new Product()
        product.setId(id)
        employee.setProducts([product])
        product.setEmployee(employee)

        when:
        productService.deleteProduct(id)

        then:
        1 * productRepository.findById(id) >> Optional.of(product)
        1 * employeeRepository.save(employee)
        1 * productRepository.delete(product)
        employee.getProducts().isEmpty()

    }
}
