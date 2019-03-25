package my.home.springtest.controller;

import my.home.springtest.dto.SimpleDTO;
import my.home.springtest.service.SimpleDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class SimpleDTOController {

    @Autowired
    private SimpleDTOService simpleDTOService;

    @GetMapping(value = "/simpleDTO", produces = APPLICATION_JSON_VALUE)
    public SimpleDTO getSimpleDTO(){
        return simpleDTOService.getSimpleDTO();
    }

}
