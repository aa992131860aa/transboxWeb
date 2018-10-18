package org.transbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/transboxWeb")
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String list(Model model) {

        return "index"; //  /WEB-INF/jsp/"list".jsp
    }
}
