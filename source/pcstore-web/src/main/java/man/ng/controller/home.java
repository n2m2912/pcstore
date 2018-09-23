package man.ng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class home {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final String index() {
        return "home/home";
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public final String detail() {
        return "detail/detail";
    }
    
    @RequestMapping(value = "/detail-type", method = RequestMethod.GET)
    public final String detailType() {
        return "detail-type/detail-type";
    }
    
}
