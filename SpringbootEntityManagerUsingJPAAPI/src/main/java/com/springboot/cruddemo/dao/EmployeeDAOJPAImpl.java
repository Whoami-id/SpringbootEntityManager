
package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    public List<Employee> findAll() {

        final Query query = entityManager.createQuery("from Employee", Employee.class);

        final List<Employee> employee = query.getResultList();

        return employee;
    }

    @Override
    public Employee findById(final int id) {

        final Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void save(final Employee employee) {

        final Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());

    }

    @Override
    public void deleteById(final int id) {
        final Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}
