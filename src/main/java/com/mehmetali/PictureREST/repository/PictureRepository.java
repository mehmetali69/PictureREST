package com.mehmetali.PictureREST.repository;

import com.mehmetali.PictureREST.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

public interface PictureRepository extends JpaRepository<Picture,Long> {

}
