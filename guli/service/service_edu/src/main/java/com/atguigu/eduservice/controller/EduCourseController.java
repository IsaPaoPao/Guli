package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.ResultData;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.service.EduCourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-09-18
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Resource
    private EduCourseService courseService;

    //添加课程基本信息方法
    @PostMapping("/addCourseInfo")
    public ResultData addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        if (StringUtils.isBlank(courseInfoVo.getSubjectId()) || StringUtils.isBlank(courseInfoVo.getSubjectParentId())){
            return ResultData.error().data("参数不能为空","参数不能为空");
        }
        String id = courseService.saveCourseInfo(courseInfoVo);
        return ResultData.ok().data("courseId",id);
    }

    //根据课程id查询课程基本信息
    @GetMapping("/getCourseInfo/{courseId}")
    public ResultData getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return ResultData.ok().data("courseInfoVo",courseInfoVo);
    }

    //修改课程信息
    @PostMapping("/updateCourseInfo")
    public ResultData updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return ResultData.ok();
    }

}

