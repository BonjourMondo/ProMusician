package com.promusician.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Properties;

@Component
public class KafkaMessageConsumer extends Thread{
    public static final Logger log= Logger.getLogger(KafkaMessageConsumer.class.getName());
    private Properties prop;
    private final KafkaConsumer<String, String> consumer;
    public KafkaMessageConsumer(){
        prop = KafkaXmlConfig.getConsumerProp();
        consumer = new KafkaConsumer<>(prop);
        consumer.subscribe(Collections.singletonList("Music"));
        log.debug("kafka consumer start");
        this.start();
    }

    @Override
    public void run() {
        log.debug("start thread");
        try {
            while (true){
                ConsumerRecords<String,String> records=consumer.poll(100);
                for (ConsumerRecord<String,String> record: records) {
                    log.debug(record.topic()+" "+record.value());
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
