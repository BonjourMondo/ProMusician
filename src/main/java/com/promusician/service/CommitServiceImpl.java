package com.promusician.service;

import com.promusician.kafka.KafkaMessageProducer;
import com.promusician.mapper.MusicMapper;
import com.promusician.model.GalleryDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commitservice")
public class CommitServiceImpl implements CommitService{
    public static Logger logger = LoggerFactory.getLogger(CommitServiceImpl.class);
    @Autowired
    private KafkaMessageProducer producer;

    @Autowired
    private MusicMapper musicMapper;

    public void CheckandCommit(String description,String title){
        //创建并保存文件
        try {
            GalleryDTO galleryDTO = new GalleryDTO();
            if (!StringUtils.isEmpty(description))
                galleryDTO.setDescription(description);
            if (!StringUtils.isEmpty(title))
                galleryDTO.setTitle(title);
            //后期再改
            galleryDTO.setFile_url("data/stone/"+title+".stone");
            galleryDTO.setImg_url("assets/stone/counting_stars.png");
            musicMapper.saveMusic(galleryDTO);
        }catch (Exception e){
            try {
                producer.send(title,description);
            } catch (Exception e1) {
                logger.debug("保存失败");
//                e1.printStackTrace();
            }
        }

    }
}
