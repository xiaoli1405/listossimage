package com.example.listossimage.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer imgId;

    @Column
    private String imgUrl;

    @Column
    private String imgText;
}
