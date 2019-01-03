package com.promusician.kafka;

import com.promusician.mapper.MusicMapper;
import com.promusician.model.GalleryDTO;
import com.promusician.model.Music;
import com.promusician.service.CommitDatebaseService;
import org.apache.commons.lang3.StringUtils;
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
                    String[] s=record.value().split("\\|");
                    GalleryDTO galleryDTO=new GalleryDTO();
                    if (!StringUtils.isEmpty(s[1]))
                        galleryDTO.setDescription(s[1]);
                    if (!StringUtils.isEmpty(s[0])) {
                        galleryDTO.setTitle(s[0]);
                        galleryDTO.setFile_url("data/stone/"+s[0]+".stone");
                    }
                    galleryDTO.setImg_url("assets/stone/counting_stars.png");
                    commitDatebaseService.saveMusic(galleryDTO);
//                    log.debug("the select id's name is "+music.getName());
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
