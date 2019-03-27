package my.home.springtest.controller;

import my.home.springtest.dto.SimpleDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleDTOControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test(){
        final ResponseEntity<SimpleDTO> entity = restTemplate.getForEntity("/simpleDTO", SimpleDTO.class);
        assertSame(entity.getStatusCode(), HttpStatus.OK);
        final SimpleDTO simpleDTO = entity.getBody();
        assertNotNull(simpleDTO);
        assertNotNull(simpleDTO.getDate());
    }

}