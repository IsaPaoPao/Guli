package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.ResultData;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-09-18
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {

    @Resource
    private EduVideoService videoService;

    //添加小节
    @PostMapping("/addVideo")
    public ResultData addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return ResultData.ok();
    }
    //删除小节
    //TODO 后面需要完善：删除小节时，同时把里面视频删除
    @DeleteMapping("/{id}")
    public ResultData addVideo(@PathVariable String id){
        videoService.removeById(id);
        return ResultData.ok();
    }

    //根据id查询小节
    @GetMapping("/getVideoInfo/{id}")
    public ResultData getVideoInfo(@PathVariable String id){
        EduVideo video = videoService.getById(id);
        return ResultData.ok().data("video",video);
    }
    //修改小节
    @PostMapping("/updateVideo")
    public ResultData updateVideo(@RequestBody EduVideo eduVideo){
        videoService.updateById(eduVideo);
        return ResultData.ok();
    }

}

