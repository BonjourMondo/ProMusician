package com.promusician.service;

import com.promusician.kafka.KafkaMessageConsumer;
import com.promusician.kafka.KafkaMessageProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commitservice")
public class CommitServiceImpl implements CommitService{
    public static final Logger log= Logger.getLogger(CommitServiceImpl.class.getName());
    @Autowired
    private KafkaMessageProducer producer;
    public void CheckandCommit(){
        try {
            producer.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
