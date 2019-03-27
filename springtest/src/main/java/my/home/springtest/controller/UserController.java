package my.home.springtest.controller;

import my.home.springtest.entity.User;
import my.home.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/all", produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
    public User getUserByName(@RequestParam("name") String name){
        return userService.getUserByName(name);
    }
}
