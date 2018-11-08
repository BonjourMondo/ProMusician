package com.promusician.web;

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
    static Logger logger= Logger.getLogger(TextareaController.class.getName());

    @RequestMapping(method = RequestMethod.POST)
    public void getText( HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        //response
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("恭喜");
        out.flush();
        out.close();
        //request
        request.setCharacterEncoding("UTF-8");
        String s=request.getParameter("str");
        logger.debug(s);

    }
}