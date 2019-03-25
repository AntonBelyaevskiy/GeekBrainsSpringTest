package my.home.springtest.json;

import my.home.springtest.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RunWith(SpringRunner.class)
public class ExternalizationTest {

    @Autowired(required = false)
    private JacksonTester<User> json;

    @Test
    public void toJsonTest() throws IOException {
        final User user = new User("test", "test@test");
        assertThat(json.write(user))
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("test");
        assertThat(json.write(user))
                .extractingJsonPathStringValue("@.email")
                .isEqualTo("test@test");
    }

}
