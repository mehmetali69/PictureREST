package com.mehmetali.PictureREST.controller;


import com.mehmetali.PictureREST.model.Picture;
import com.mehmetali.PictureREST.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    @GetMapping(value = "/pictures")
    public Picture givePictures(){
        return pictureRepository.findAll().get(0);


    }
}
