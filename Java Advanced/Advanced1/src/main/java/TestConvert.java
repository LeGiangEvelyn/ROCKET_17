import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.repository.SalaryRepository;

import java.util.List;

public class TestConvert {
    public static void main(String[] args) {
        SalaryRepository repository = new SalaryRepository();

        System.out.println("***********GET ALL Salaries***********");

        List<Salary> salaries = repository.getAllSalaries();

        for (Salary salary : salaries) {
            System.out.println(salary);
        }

        System.out.println("\n\n***********CREATE Salary***********");

        Salary salary = new Salary();
        salary.setName(SalaryName.PM);
        repository.createSalary(salary);
    }
}
