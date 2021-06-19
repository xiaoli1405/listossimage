package com.example.listossimage.service.impl;

import com.example.listossimage.entity.Image;
import com.example.listossimage.repository.ImageRepository;
import com.example.listossimage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageIServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> GetImage() {
        return imageRepository.GetImage();
    }
}
