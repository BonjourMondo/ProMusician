package com.promusician.service;

import com.promusician.stone.BasicParser;
import com.promusician.stone.InterpreterRunner;
import com.promusician.stone.env.BasicEnv;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Author: LeesangHyuk
 * Date: 2018/12/28 9:34
 * Description:检查语义，并且运行
 */

@Service("checkandrunservice")
public class RunnerServiceImpl implements RunnerService{

    @Override
    public void CheckAndRun(String str) {
        ArrayList<String> strings=InterpreterRunner.runCode(new BasicParser(),new BasicEnv(),str);
    }
}
