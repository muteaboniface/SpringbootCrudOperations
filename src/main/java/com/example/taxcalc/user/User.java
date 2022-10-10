package com.example.taxcalc.user;


import javax.persistence.*;

@Entity // Hibernate
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private long id;
    private String name;
    private String email;
    private float basic_salary;

    // constructors, Lombok could be used to avoid all the boilerplate code
    public User() {
    }

    public User(String name, String email, float basic_salary) {
        this.name = name;
        this.email = email;
        this.basic_salary = basic_salary;
    }

    public User(long id, String name, String email, float basic_salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.basic_salary = basic_salary;
    }
    // Generate Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(float basic_salary) {
        this.basic_salary = basic_salary;
    }

    // toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", basic_salary=" + basic_salary +
                '}';
    }
}
