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
    public PictureRepository pictureRepository;

    @Override
    public void run(String... args) throws Exception {
        Picture myPic = new Picture("TestTitle","Test Description...", LocalDateTime.now());
        Picture myPic2 = new Picture("2TestTitle","2Test Description...", LocalDateTime.now());
        pictureRepository.save(myPic);
        pictureRepository.save(myPic2);
        System.out.println(pictureRepository.findById(1L));

    }
}
