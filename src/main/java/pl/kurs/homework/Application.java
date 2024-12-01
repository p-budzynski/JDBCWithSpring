package pl.kurs.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.kurs.homework.entity.Employee;
import pl.kurs.homework.entity.Position;
import pl.kurs.homework.srvice.EmployeeService;

@ComponentScan
@Configuration
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Application.class);

        EmployeeService service = ctx.getBean(EmployeeService.class);

        Employee employee = new Employee("Adam", "Nieprzekładam", Position.SENIOR_DEV, 8500.0);

        service.hireEmployee(employee);

        service.increaseSalaryById(210L);

        service.promoteEmployee(210L, "lead dev");

        service.fireEmployee(210L);

        System.out.println(service.findEmployeeById(210L));

        ctx.close();
    }

}
