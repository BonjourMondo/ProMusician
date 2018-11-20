package com.promusician.web;

import com.promusician.kafka.KafkaMessageConsumer;
import com.promusician.service.AnalyserServiceImpl;
import com.promusician.service.CommitService;
import com.promusician.service.CommitServiceImpl;
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

@Controller
@RequestMapping("/textarea")
public class TextareaController {
//    static Logger logger=Logger.getLogger(TextareaController.class.getName());

    @Autowired
    @Qualifier("analyserservice")
    private AnalyserServiceImpl analyserService;

    @Autowired
    @Qualifier("commitservice")
    private CommitServiceImpl commitService;

    @RequestMapping(method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public void getText(HttpServletResponse response,
                        @RequestParam(value = "str") String code, Model model) throws IOException {
        //request
        boolean response_state = analyserService.analyseInputText(code);

        //response
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(analyserService.returnOutPutText(response_state));
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/commit")
    public String getCommitText(Model model) throws IOException {
        commitService.CheckandCommit();
        return "success_commit";
    }


}
