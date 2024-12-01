package pl.kurs.homework.srvice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kurs.homework.dao.EmployeeDao;
import pl.kurs.homework.entity.Employee;
import pl.kurs.homework.entity.Position;

@Component
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public void hireEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void fireEmployee(Long employeeId) {
        Employee employee = employeeDao.get(employeeId);
        employee.setFired(true);
        employeeDao.update(employee);
    }

    public void increaseSalaryById(Long employeeId) {
        Employee employee = employeeDao.get(employeeId);
        employee.setSalary(employee.getSalary() * 1.2);
        employeeDao.update(employee);
    }

    public void promoteEmployee(Long employeeId, String newPosition) {
        Employee employee = employeeDao.get(employeeId);
        employee.setJobPosition(Position.fromDbValue(newPosition));
        employeeDao.update(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeDao.get(employeeId);
    }
}
