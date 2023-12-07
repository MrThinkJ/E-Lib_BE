package com.dtu.elibrary.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectConfig {
    @Bean
    public Cloudinary getCloudinary(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dyj83asmu",
                "api_key", "513122117192341",
                "api_secret", "gK51cmay_PQ3AbsNytlRDlBSNIE"));
        return cloudinary;
    }
}
