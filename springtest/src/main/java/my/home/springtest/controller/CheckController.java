package my.home.springtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.TEXT_PLAIN_VALUE;

@RestController
public class CheckController {

    @RequestMapping(value = "/check", method = RequestMethod.GET, produces = TEXT_PLAIN_VALUE)
    public String check(){
        return "I'm alive";
    }

}
