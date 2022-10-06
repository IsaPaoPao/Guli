package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.ResultData;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.service.EduChapterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-09-18
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {

    @Resource
    private EduChapterService chapterService;

    //课程大纲列表
    @GetMapping("/getChapterVideo/{courseId}")
    public ResultData getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return ResultData.ok().data("allChapterVideo",list);
    }

    //添加章节
    @PostMapping("/addChapter")
    public ResultData addChapter(@RequestBody EduChapter eduChapter){
        chapterService.save(eduChapter);
        return ResultData.ok();
    }

    //根据id查询章节
    @GetMapping("/getChapterInfo/{chapterId}")
    public ResultData getChapterInfo(@PathVariable String chapterId){
        EduChapter chapter = chapterService.getById(chapterId);
        return ResultData.ok().data("chapter",chapter);
    }

    //修改章节
    @PostMapping("/updateChapter")
    public ResultData updateChapter(@RequestBody EduChapter eduChapter){
        chapterService.updateById(eduChapter);
        return ResultData.ok();
    }

    //删除方法
    @DeleteMapping("{chapterId}")
    public ResultData deleteChapter(@PathVariable String chapterId){
        boolean flag = chapterService.deleteChapter(chapterId);
        return ResultData.ok();
    }



}

