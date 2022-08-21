package com.atguigu.oss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HTH
 * @create 2022-08-14 19:07
 */
public interface OssService {
    String uploadFileAvator(MultipartFile file);
}
