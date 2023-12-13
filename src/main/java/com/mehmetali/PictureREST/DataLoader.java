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

    // DB mit Beispieldaten füllen beim StartUp
    @Override
    public void run(String... args) throws Exception {
        Picture myPic = new Picture("TestTitle","Test Description...of the first picture", LocalDateTime.now());
        Picture myPic2 = new Picture("2.Bild - Titel","Zweite Beschreibung...", LocalDateTime.now());
        Picture myPic3 = new Picture("3.Bild - Titel","Dritte Beschreibung...", LocalDateTime.now().minusDays(1L));
        pictureRepository.save(myPic);
        pictureRepository.save(myPic2);
        pictureRepository.save(myPic3);
        //System.out.println(pictureRepository.findById(1L));

    }
}
