package pl.kurs.homework.srvice;

import pl.kurs.homework.dao.EmployeeDao;
import pl.kurs.homework.entity.Employee;
import pl.kurs.homework.entity.Position;

public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

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
        employee.setJob_position(Position.fromDbValue(newPosition));
        employeeDao.update(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeDao.get(employeeId);
    }
}
