package com.promusician.controller;

import com.alibaba.fastjson.JSON;
import com.promusician.service.AnalyserServiceImpl;
import com.promusician.service.CommitServiceImpl;
import com.promusician.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/textarea")
public class TextareaController {
    public static Logger logger=LoggerFactory.getLogger(TextareaController.class);

    @Autowired
    @Qualifier("analyserservice")
    private AnalyserServiceImpl analyserService;

    @Autowired
    @Qualifier("commitservice")
    private CommitServiceImpl commitService;


    @RequestMapping(method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public void getText(HttpServletResponse response,
                        @RequestParam(value = "str") String code) throws IOException {
        //request
//        logger.debug(code);
        String analyseCode = analyserService.analyseInputText(code);
        logger.debug("处理结果为：{}", analyseCode);
        //传值为json
        Map<String,String> map=new HashMap<>();
        map.put("code",analyseCode);
        String objJSON= JSON.toJSONString(map);
        Util.returnJson(response,objJSON);
    }

    @RequestMapping(value = "/commit")
    public String getCommitText(Model model) throws IOException {
        commitService.CheckandCommit();
        return "success_commit";
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "success_commit";
    }

}
