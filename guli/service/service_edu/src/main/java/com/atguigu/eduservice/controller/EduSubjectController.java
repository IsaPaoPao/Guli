package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.ResultData;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.FileHandler;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-08-21
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Resource
    private EduSubjectService subjectService;

    //添加课程分类
    //获取上传过来的文件，把文件内容读取出来
    @PostMapping("/addSubject")
    public ResultData addSubject(MultipartFile multipartFile){
        //上传过来的文件
        subjectService.saveSubject(multipartFile,subjectService);
        return ResultData.ok();
    }

    //课程提交树形
    @PostMapping("/getAllSubject")
    public ResultData getAllSubject(){
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return ResultData.ok().data("list",list);
    }


}

