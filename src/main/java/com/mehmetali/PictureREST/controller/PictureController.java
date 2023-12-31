package com.mehmetali.PictureREST.controller;


import com.mehmetali.PictureREST.model.Picture;
import com.mehmetali.PictureREST.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    // alle Bilder zurueckgeben
    @GetMapping(value = "/pictures")
    public List<Picture> getPictures(){
        return pictureRepository.findAll();
    }

    // Bild anhand ID zurueckgeben
    @GetMapping(value = "/pictures/{id}")
    public Optional<Picture> getPictureById(@PathVariable Long id){
        return pictureRepository.findById(id);
    }

    // Vorhandenes Bild ändern
    @PutMapping(value = "/pictures/{id}")
    public ResponseEntity<Picture> updatePicture(@PathVariable Long id, @RequestBody Picture newPicture){
        Picture oldPicture = pictureRepository.findById(id).get();
        oldPicture.setTitle(newPicture.getTitle());
        oldPicture.setDescription(newPicture.getDescription());
        oldPicture.setCreated(newPicture.getCreated());
        oldPicture.setTags(newPicture.getTags());
        oldPicture.setData(newPicture.getData());

        return new ResponseEntity<>(pictureRepository.save(oldPicture), HttpStatus.OK);
    }

    /*
    // Test Methode
    @GetMapping(value = "/pictures/new")
    public Optional<Picture> getPictureById(){
        return pictureRepository.findById(2l);
    }*/

    // neues Bild anlegen
    @PostMapping(value = "/pictures/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Picture> create(@RequestBody Picture newPicture) {

        Picture picture = pictureRepository.save(newPicture);
        if (picture == null) {
            throw new NullPointerException();
        } else {
            return new ResponseEntity<>(picture, HttpStatus.CREATED);
        }
    }

}
