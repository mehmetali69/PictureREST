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

    @GetMapping(value = "/pictures")
    public List<Picture> getPictures(){
        return pictureRepository.findAll();
    }

    @GetMapping(value = "/pictures/{id}")
    public Optional<Picture> getPictureById(@PathVariable Long id){
        return pictureRepository.findById(id);
    }

/*    @GetMapping(value = "/pictures/new")
    public Optional<Picture> getPictureById(){
        return pictureRepository.findById(2l);
    }*/

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
