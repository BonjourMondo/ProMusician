package com.promusician.controller;

import com.alibaba.fastjson.JSON;
import com.promusician.service.*;
import com.promusician.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/textarea")
public class TextareaController {
    public static Logger logger=LoggerFactory.getLogger(TextareaController.class);

    @Autowired
    @Qualifier("analyserservice")
    private AnalyserService analyserService;

    @Autowired
    @Qualifier("commitservice")
    private CommitService commitService;

    @Autowired
    @Qualifier("checkandrunservice")
    private RunnerService runnerService;


    @RequestMapping(method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public void getText(HttpServletResponse response,
                        @RequestParam(value = "str") String code) throws IOException {
        //request
        String[] strings=code.split("\n");
        String analyse_text="";//为了处理空格，否则会报错
        for (String s:strings) {
           analyse_text=analyse_text+s.trim()+"\n";
        }
        String analyseCode = analyserService.analyseInputText(analyse_text);
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


    /*
    ajax传值
     */
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    public void getRunnerText(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String s=request.getParameter("str");
        logger.debug("试运行代码中...{}",s);
        if (StringUtils.isEmpty(s)){
            throw new Exception("传值空异常");
        }
        runnerService.CheckAndRun(s);
        //传值为json
        Map<String,String> map=new HashMap<>();
        map.put("code",s);
        String objJSON= JSON.toJSONString(map);
        Util.returnJson(response,objJSON);
    }

}