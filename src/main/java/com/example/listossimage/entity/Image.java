package com.example.listossimage.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Image {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String imgId;

    @Column
    private String imgUrl;

    @Column
    private String imgText;
}
