package my.home.springtest.service;

import my.home.springtest.dto.SimpleDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Service
public class SimpleDTOService {

    private static final Logger LOGGER = Logger.getLogger(SimpleDTOService.class.getSimpleName());

    private SimpleDTO simpleDTO;

    @PostConstruct
    private void init(){
        simpleDTO = new SimpleDTO();
    }

    public SimpleDTO getSimpleDTO(){
        LOGGER.info("Get SimpleDTO");
        return simpleDTO;
    }

    public void deleteSimpleDTO(){
        LOGGER.info("Delete SimpleDTO");
        simpleDTO = null;
    }

    public SimpleDTO createUserSimpleDTO(){
        LOGGER.info("Create SimpleDTO");
        return new SimpleDTO();
    }

}
