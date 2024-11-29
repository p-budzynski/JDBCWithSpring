package pl.kurs.homework.dao;

import pl.kurs.homework.entity.Employee;

public interface EmployeeDao {
    void save(Employee employee);

    void update(Employee employee);

    Employee get(Long id);
}
