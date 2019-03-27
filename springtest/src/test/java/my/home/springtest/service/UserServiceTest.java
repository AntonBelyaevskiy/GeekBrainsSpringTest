package my.home.springtest.service;

import my.home.springtest.entity.User;
import my.home.springtest.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class ServiceImplTestContextConfiguration{
        @Bean
        public UserService userService(){
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testServiceCreate(){
        userService.createUser("test", "test@test.ru");
        assertNotNull(userService.getAllUsers());
    }

    @Test
    public void testRepositoryCreate(){
        final User user = new User();
        user.setName("testName");
        user.setEmail("test@mail.ru");
        userRepository.save(user);
    }

}