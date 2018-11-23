package com.promusician.mapper;

import com.promusician.model.Music;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public interface MusicMapper {
    void saveMusic(Music music);
    Music selectMusicById(Integer id);
}
