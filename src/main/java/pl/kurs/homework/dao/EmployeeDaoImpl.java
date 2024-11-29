package pl.kurs.homework.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import pl.kurs.homework.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceUnit
    private EntityManagerFactory managerFactory;

    @Override
    public void save(Employee employee) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Employee employee) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Employee get(Long id) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }
}
