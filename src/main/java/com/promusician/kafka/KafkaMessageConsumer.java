package com.promusician.kafka;

import com.promusician.mapper.MusicMapper;
import com.promusician.model.Music;
import com.promusician.service.CommitDatebaseService;
import org.apache.kafka.clients.consumer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Properties;

@Component
public class KafkaMessageConsumer extends Thread{
    public static Logger log = LoggerFactory.getLogger(KafkaMessageConsumer.class);
    private Properties prop;
    private final KafkaConsumer<String, String> consumer;

    @Autowired
    @Qualifier("commitdatebaseserivce")
    private CommitDatebaseService commitDatebaseService;

    public KafkaMessageConsumer(){
        prop = KafkaXmlConfig.getConsumerProp();
        consumer = new KafkaConsumer<>(prop);
        consumer.subscribe(Collections.singletonList("Music"));
//        log.debug("kafka consumer start");
        this.start();
    }

    @Override
    public void run() {
//        log.debug("start thread");
        try {
            while (true){
                ConsumerRecords<String,String> records=consumer.poll(100);
                for (ConsumerRecord<String,String> record: records) {
                    log.debug(record.topic()+" "+record.value());
                    Music music=commitDatebaseService.selectByid(2);
                    log.debug("the select id's name is "+music.getName());
                }
                try {
                    consumer.commitAsync();
                }catch (Exception e){
                    log.error("Unexcept Error",e);
                }
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    log.error("超时");
                }
            }
        }finally {
            try {
                consumer.commitSync();
            }finally {
                consumer.close();
            }
        }
    }
}
