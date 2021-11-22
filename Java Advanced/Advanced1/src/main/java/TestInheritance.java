import com.vti.entity.Department;
import com.vti.entity.Employee;
import com.vti.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class TestInheritance {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();

        System.out.println("****************** GET ALL EMPLOYEES **********************");
        List<Employee> employees = repository.getAllEmployees();

        for (Employee employee : employees){
            System.out.println(employee.getUsername() + " " + employee.getWorkingYear());
        }

        System.out.println("****************** CREATE EMPLOYEE ************************");
        Employee employee = new Employee();
        employee.setUsername("Giang");
        employee.setEmail("giangle@gmail.com");
        employee.setFirstName("Giang");
        employee.setLastName("Le");
        employee.setWorkingYear((short) 2);
        repository.createEmployee(employee);
    }
}
