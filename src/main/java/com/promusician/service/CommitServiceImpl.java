package com.promusician.service;

import com.promusician.kafka.KafkaMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commitservice")
public class CommitServiceImpl implements CommitService{
    public static Logger logger = LoggerFactory.getLogger(CommitServiceImpl.class);
    @Autowired
    private KafkaMessageProducer producer;
    public void CheckandCommit(){
        try {
            producer.send();
        } catch (Exception e) {
            //另外的方式提交
            logger.debug("kafka出错，直接放入数据库中");
//            e.printStackTrace();
        }
    }
}
