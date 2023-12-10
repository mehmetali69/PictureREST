package com.mehmetali.PictureREST;

import com.mehmetali.PictureREST.model.Picture;
import com.mehmetali.PictureREST.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class PictureRestApplication {



	public static void main(String[] args) {
		SpringApplication.run(PictureRestApplication.class, args);

	}

}
