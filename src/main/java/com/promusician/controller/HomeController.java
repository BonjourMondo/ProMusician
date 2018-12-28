package com.promusician.controller;

import com.promusician.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

@Controller
@RequestMapping(value={"/","/homepage"})
public class HomeController {
    public static Logger logger= LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message","Bounjour Mondo!");
        return "index";
    }

    @RequestMapping("/musician")
    public String pro_musician(Model model) throws IOException {
        //相对路径
        String pathname = "data/lex.stone";
        InputStream in = HomeController.class.getClassLoader().getResourceAsStream(pathname);
        String text= Util.inputStreamToString(in);
        model.addAttribute("template_promusician",text.trim());
        logger.debug("成功载入lex.stone");
        return "pro_musician";
    }

    @RequestMapping("/drums")
    public String drums(Model model){
        return "pro_drums";
    }

}