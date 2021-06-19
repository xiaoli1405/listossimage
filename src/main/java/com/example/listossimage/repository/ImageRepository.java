package com.example.listossimage.repository;

import com.example.listossimage.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query(value = "select * from image", nativeQuery = true)
    List<Image> GetImage();

    @Modifying
    @Query(value = " insert into image(img_url, img_text) value(#{imgUrl}, #{imgText})", nativeQuery = true)
    void InsertImage(String imgUrl, String imgText);
}
