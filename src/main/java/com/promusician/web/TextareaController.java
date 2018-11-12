package com.promusician.web;

import com.promusician.service.AnalyserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/textarea")
public class TextareaController {

    @Autowired
    @Qualifier("analyserservice")
    private AnalyserServiceImpl analyserService;

    @RequestMapping(method = RequestMethod.POST)
    public void getText( HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        //request
        request.setCharacterEncoding("UTF-8");
        String s = request.getParameter("str");
        boolean response_state = analyserService.analyseInputText(s);

        //response
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(analyserService.returnOutPutText(response_state));
        out.flush();
        out.close();
    }
}
