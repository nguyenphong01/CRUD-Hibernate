import entity.Department;
import repository.DepartmentRepository;
import utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        DepartmentRepository repository = new DepartmentRepository();

        System.out.println("------------CREATE DEPARTMENT------------");
        repository.create(new Department("Java Basic"));
        repository.create(new Department("Java Advanced"));
        repository.create(new Department("Frontend"));

        System.out.println("------------SHOW ALL------------");
        List<Department> departments = repository.findAll();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }

        System.out.println("------------SHOW BY ID------------");
        Department department = repository.findById(2);
        System.out.println("department = " + department);

        System.out.println("------------UPDATE------------");
        repository.update(new Department(1, "SQL"));

        System.out.println("------------DELETE------------");
        repository.deleteById(3);

        System.out.println("------------SHOW ALL------------");
        List<Department> ds = repository.findAll();
        for (Department d : ds) {
            System.out.println("department = " + d);
        }

        HibernateUtils.closeFactory();
    }
}
