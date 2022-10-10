package com.example.taxcalc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// makes this class serve rest endpoints
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {


    final UserService userService;

    @Autowired
    // autowires>>Injects userService to the constructor UserController
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    // makes the method getUsers a Rest Endpoint, of type get
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void addNewUser(@RequestBody User user){
        // get data from the request body and map it to user
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        // Take the path variable and map it to userId
        // Validations can be performed to ensure that the path variable conforms
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userid,
            @RequestParam(required = false) String name, //not explicitly required
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Float salary
    ){
        userService.updateUser(userid,name,email,salary);

    }

}
