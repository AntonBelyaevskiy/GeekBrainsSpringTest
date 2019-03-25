package my.home.springtest.repository;

import my.home.springtest.Application;
import my.home.springtest.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName(){
        assertEquals(userRepository.count(), 0);
        assertNull(userRepository.getUserByName("DEMO"));
        final User user = new User("demo", "demo@demo.ru");
        userRepository.save(user);
        assertEquals(userRepository.count(), 1);
        assertNotNull(userRepository.getUserByName("demo"));
        userRepository.delete(user);
    }

    @Test
    public void testCRUD(){
        userRepository.deleteAll();
        assertTrue(userRepository.findAll().isEmpty());
        userRepository.save(new User());
        assertFalse(userRepository.findAll().isEmpty());
        userRepository.deleteAll();
        assertTrue(userRepository.findAll().isEmpty());
    }

}