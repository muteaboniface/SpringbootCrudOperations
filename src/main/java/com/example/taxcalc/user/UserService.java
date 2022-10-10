package com.example.taxcalc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Component
@Service
// both @component and @Service could be used. however, @Service is preferred for semantics. it's easily understandable.
// The injection allows us to indicate that the class has to be instantiated, i,e A spring bean
public class UserService {

    // Business Logic

    private UserRepository userRepository;
    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        // return List.of("Hello","Earth"); // returns unmodifiable list
        // List<User> data = new ArrayList<User>();
        // userRepository.findAll().forEach(data::add);
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userExists = userRepository.findUserByName(user.getName());
        // Perform your validation checks
        // Good Exception handling techniques should be employed
        // uniqueness could be based on email
        if (userExists.isPresent()){
            throw new IllegalStateException("Username Exists");
        }
        // Save user
        userRepository.save(user);

    }

    public void deleteUser(Long userId) {
        boolean isId = userRepository.existsById(userId);
        if(!isId){
            throw new IllegalStateException("User with Id " + userId+ " does not exist");
        }
        // delete user
        userRepository.deleteById(userId);
    }

    @Transactional
    // means you dont need to write any JPquery for update action
    // Entity goes into a managed state.
    public void updateUser(Long userId, String name, String email, Float salary) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("User with Id "+ userId + " does not exist"));


        // name check
        if (name != null && name.length() > 0 &&
        !Objects.equals(user.getName(),name)){
            user.setName(name);

        }

        // email check
        if (email != null && email.length() > 0 &&
                !Objects.equals(user.getEmail(),email)){
            //check if email exists
            Optional<User> emailExists = userRepository.findUserByEmail(email);
            if(emailExists.isPresent()){
                throw new IllegalStateException("Email Exists!");
            }
            user.setEmail(email);

        }

        // salary
        if (salary != null && salary != 0 &&
                !Objects.equals(user.getBasic_salary(),salary)){
            user.setBasic_salary(salary);

        }
    }

}
