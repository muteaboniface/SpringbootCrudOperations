package com.example.taxcalc.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    // SELECT * FROM user WHERE name = ?
    // @Query("SELECT u FROM User u WHERE u = ?1")
    // User is the Entity defined in User Class
    Optional<User> findUserByName(String name);

    Optional<User> findUserByEmail(String email);


    //    public List<User> findById(String name);
    //    @Query("SELECT e FROM User e WHERE e.basic_salary >= :basic_salary")
    //    public List<User> listUsersWithSalaryOver(@Param("basic_salary") float basic_salary);
}