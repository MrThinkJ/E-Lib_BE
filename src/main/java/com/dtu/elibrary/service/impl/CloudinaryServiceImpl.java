package com.dtu.elibrary.service.impl;

import com.cloudinary.Cloudinary;
import com.dtu.elibrary.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public Map upload(MultipartFile file) {
        Map data;
        try{
            data = this.cloudinary.uploader().upload(file.getBytes(), Map.of());
        } catch (IOException e){
            throw new RuntimeException("Upload image failed !");
        }
        return data;
    }
}
