package com.atguigu.oss.controller;

import com.atguigu.commonutils.ResultData;
import com.atguigu.oss.service.OssService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author HTH
 * @create 2022-08-14 19:07
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Resource
    private OssService ossService;

    //上传头像方法
    @PostMapping
    public ResultData uploadOssFile(MultipartFile file){
        //获取上传的文件MultipartFile
        //返回上传到oss的路径url
        String url = ossService.uploadFileAvator(file);
        return ResultData.ok().data("url",url);
    }
}
