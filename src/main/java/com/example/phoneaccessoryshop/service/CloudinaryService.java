package com.example.phoneaccessoryshop.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

public interface CloudinaryService {

   String upload(MultipartFile imageFile);
}
