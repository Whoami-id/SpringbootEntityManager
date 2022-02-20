
package com.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String fristName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Employee() {

    }

    public Employee(final String fristName, final String lastName, final String email) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", email=" + email + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(final String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

}
