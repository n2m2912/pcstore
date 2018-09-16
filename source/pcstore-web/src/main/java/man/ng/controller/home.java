package man.ng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class home {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final String home() {
        return "home/home";
    }
}
