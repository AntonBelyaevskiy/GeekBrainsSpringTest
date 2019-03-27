package my.home.springtest.configuration;

import my.home.springtest.entity.User;
import my.home.springtest.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LoadConfiguration {

    private static final Logger LOGGER = Logger.getLogger(LoadConfiguration.class.getSimpleName());

    @Bean
    public CommandLineRunner loadService(UserService userService){
        return args -> {
            LOGGER.info("Start load data");

            final User user1 = userService.createUser("user_1", "one@user.ru");
            final User user2 = userService.createUser("user_2", "two@user.ru");

            LOGGER.info(user1.toString());
            LOGGER.info(user2.toString());

            LOGGER.info("Data was loaded");
        };
    }

}
