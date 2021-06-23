package com.example.listossimage.repository;

import com.example.listossimage.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>, JpaSpecificationExecutor<Image> {

//    @Query(value = "select * from image", nativeQuery = true)
////    List<Image> GetImage();
////
////    @Query(value = " insert into image(img_url, img_text) values ( ?1 , ?2) ", nativeQuery = true)
////    Integer InsertImage(String imgUrl, String imgText);
////
////    @Query(value = "select * from image where img_text = ?1 ", nativeQuery = true)
////    Image getImagesByImgText(String imgText);
////
////    @Query(value = "select max (img_id) from image", nativeQuery = true)
////    Integer getMaxId();
}
