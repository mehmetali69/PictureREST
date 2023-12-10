package com.mehmetali.PictureREST;

import com.mehmetali.PictureREST.model.Picture;
import com.mehmetali.PictureREST.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    public static PictureRepository pictureRepository;

    @Override
    public void run(String... args) throws Exception {
        Picture myPic = new Picture(2345L,"TestTitle","Test Description...", LocalDateTime.now());
        pictureRepository.save(myPic);
    }
}
