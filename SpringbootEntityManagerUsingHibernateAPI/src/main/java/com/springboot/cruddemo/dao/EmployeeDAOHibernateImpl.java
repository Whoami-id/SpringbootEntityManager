
package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entiryManager
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get current hibernate session
        final Session session = entityManager.unwrap(Session.class);

        // create query
        final Query<Employee> query = session.createQuery("from Employee", Employee.class);

        // execute query and get result lit
        final List<Employee> employee = query.getResultList();

        return employee;
    }

    @Override
    public Employee findById(final int id) {

        final Session session = entityManager.unwrap(Session.class);

        final Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void save(final Employee employye) {

        final Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employye);

    }

    @Override
    public void deleteById(final int id) {

        final Session session = entityManager.unwrap(Session.class);

        final Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);

    }

}
