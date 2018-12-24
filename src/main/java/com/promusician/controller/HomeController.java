package com.promusician.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        //绝对路径
        String pathname = "E:\\BounjourMonde\\SpringMVC\\ProMusician\\src\\main\\resources\\data\\lex.stone";
        String text="";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                text=text+line+"\n";
            }
            text=new String(text.getBytes("UTF-8"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("template_promusician",text);
        return "pro_musician";
    }

    @RequestMapping("/drums")
    public String drums(Model model){
        return "pro_drums";
    }

}
