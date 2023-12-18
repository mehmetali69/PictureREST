package com.mehmetali.PictureREST;

import com.mehmetali.PictureREST.model.Picture;
import com.mehmetali.PictureREST.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    public PictureRepository pictureRepository;

    // DB mit Beispieldaten füllen beim StartUp
    @Override
    public void run(String... args) throws Exception {
        Picture myPic = new Picture("TestTitle","Test Description...of the first picture", LocalDateTime.now(), List.of("super"),new byte[]{3,4});
        Picture myPic2 = new Picture("2.Bild - Titel","Zweite Beschreibung...", LocalDateTime.now(),List.of("super"),new byte[]{3,4});
        Picture myPic3 = new Picture("3.Bild - Titel","Dritte Beschreibung...", LocalDateTime.now().minusDays(1L),List.of("super"),new byte[]{3,4});
        pictureRepository.save(myPic);
        pictureRepository.save(myPic2);
        pictureRepository.save(myPic3);
        //System.out.println(pictureRepository.findById(1L));

    }
}
