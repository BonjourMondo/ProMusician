package com.promusician.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/","/homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message","Bounjour Mondo!");
        return "index";
    }

    @RequestMapping("/musician")
    public String pro_musician(Model model){
        return "pro_musician";
    }

    @RequestMapping("/drums")
    public String drums(Model model){
        return "pro_drums";
    }

}
