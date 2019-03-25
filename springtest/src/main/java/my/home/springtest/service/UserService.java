package my.home.springtest.service;

import my.home.springtest.entity.User;
import my.home.springtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getSimpleName());

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers(){
        LOGGER.info("Get All users");
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        LOGGER.info("Get user by id");
        return userRepository.getUserById(id);
    }

    public User getUserByName(String name){
        LOGGER.info("Get user by name");
        return userRepository.getUserByName(name);
    }

    public void deleteUser(Long id){
        LOGGER.info("Delete user by id");
        userRepository.deleteById(id);
    }

    public User createUser(String name, String email){
        LOGGER.info("Create user by id");
        final User user = new User(name, email);
        return userRepository.save(user);
    }


}
