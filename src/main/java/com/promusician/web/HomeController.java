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
        String s="package com.promusician.player;\n" +
                "public class ProMusician {\n" +
                "    public static void main(String[] args) {\n" +
                "        //创建Metronome基础乐队\n" +
                "        Metronome metronome=new Metronome();\n" +
                "        //设置BPM，即default为一秒一拍\n" +
                "        metronome.setBPM(Metronome.DEFUALT_BPM);\n" +
                "        metronome.setTempo(4);\n" +
                "        //初始化循环次数\n" +
                "        Times t=new Times(5);\n" +
                "        //初始化乐器\n" +
                "        Crash r=new Crash();\n" +
                "        r.setBeat(1);\n" +
                "        //定义演奏规则\n" +
                "        Tips tips =new Tips() {\n" +
                "            @Override\n" +
                "            public void tips() {\n" +
                "                super.tips();\n" +
                "            }\n" +
                "        };\n" +
                "        //开始演奏\n" +
                "        metronome.begin();\n" +
                "    }\n" +
                "}";
        model.addAttribute("template_promusician",s);
        return "pro_musician";
    }

    @RequestMapping("/drums")
    public String drums(Model model){
        return "pro_drums";
    }

}
