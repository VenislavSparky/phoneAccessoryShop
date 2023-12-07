package com.example.phoneaccessoryshop.service.impl;

import com.cloudinary.Cloudinary;
import com.example.phoneaccessoryshop.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final String URL_KEY = "url";
    private static final String PREFIX = "item_image";
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    @Override
    public String upload(MultipartFile imageFile) {

        File file;

        try {
            file = File.createTempFile(PREFIX,imageFile.getOriginalFilename());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            imageFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return cloudinary.uploader().upload(file, Map.of()).get(URL_KEY).toString();
        } catch (IOException e) {
            throw new RuntimeException("Image upload fail!");
        }

    }


}
