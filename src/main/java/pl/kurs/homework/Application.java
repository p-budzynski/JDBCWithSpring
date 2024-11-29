package pl.kurs.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.kurs.homework.dao.EmployeeDao;
import pl.kurs.homework.entity.Employee;
import pl.kurs.homework.entity.Position;
import pl.kurs.homework.srvice.EmployeeService;

@ComponentScan
@Configuration
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Application.class);

        EmployeeDao employeeDaoFromSpring = ctx.getBean(EmployeeDao.class);

        EmployeeService service = new EmployeeService(employeeDaoFromSpring);

        Employee employee = new Employee("Adam", "Przekładam", Position.JUNIOR_DEV, 3000.0);

//        service.hireEmployee(employee);
//
//        service.increaseSalaryById(208L);
//
//        service.promoteEmployee(208L, "lead dev");
//
//        service.fireEmployee(208L);
//
//        System.out.println(service.findEmployeeById(208L));


        ctx.close();
    }

}
