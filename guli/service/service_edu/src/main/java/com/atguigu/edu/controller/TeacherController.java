package com.atguigu.edu.controller;


import com.atguigu.commonutils.ResultData;
import com.atguigu.edu.entity.Teacher;
import com.atguigu.edu.entity.vo.TeacherQuery;
import com.atguigu.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-25
 */
@RestController
@RequestMapping("/edu/teacher")
@Slf4j
@Api(tags = "讲师管理Controller")
@CrossOrigin
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    //查询所有讲师
    @ApiOperation("所有讲师列表")
    @GetMapping("/findAll")
    public ResultData findAllTeacher(){
        List<Teacher> teacherList = teacherService.list(null);
        return ResultData.ok().data("teacherList",teacherList);
    }

    //讲师逻辑删除功能
    @ApiOperation("根据id对讲师进行逻辑删除")
    @DeleteMapping("{id}")
    public ResultData DeleteTeacherById(
                                    @ApiParam(name = "id",value = "讲师ID",required = true)
                                    @PathVariable String id){
        boolean result = teacherService.removeById(id);
        return result ? ResultData.ok() : ResultData.error();
    }

    //讲师分页查询
    @ApiOperation("讲师分页查询")
    @GetMapping("/pageTeacher/{pageNo}/{pageSize}")
    public ResultData pageListTeacher(@PathVariable long pageNo,
                                      @PathVariable long pageSize){
        //创建Page对象
        Page<Teacher> pageTeacher = new Page<>(pageNo,pageSize);
        //调用分页方法----底层会做封装，把所有数据封装到pageTeacher对象里面
        teacherService.page(pageTeacher,null);
        //总记录数
        long total = pageTeacher.getTotal();
        //每页数据的list集合
        List<Teacher> list = pageTeacher.getRecords();
        return ResultData.ok().data("total",total).data("teacherList",list);
    }

    //条件查询带分页的方法
    @ApiOperation("条件查询带分页的方法")
    @PostMapping("/pageTeacherCondition/{pageNo}/{pageSize}")
    public ResultData pageTeacherCondition(@PathVariable long pageNo,
                                           @PathVariable long pageSize,
                                           @RequestBody(required = false) TeacherQuery teacherQuery){
        //创建Page对象
        Page<Teacher> pageTeacher = new Page<>(pageNo,pageSize);
        //构建条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //多条件组合查询
        if (StringUtils.hasLength(name)){
            wrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if(StringUtils.hasLength(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if(StringUtils.hasLength(end)) {
            wrapper.le("gmt_create", end);
        }

        //排序
        wrapper.orderByDesc("gmt_create");

        //调用分页方法----底层会做封装，把所有数据封装到pageTeacher对象里面
        teacherService.page(pageTeacher,wrapper);
        //总记录数
        long total = pageTeacher.getTotal();
        //每页数据的list集合
        List<Teacher> list = pageTeacher.getRecords();
        return ResultData.ok().data("total",total).data("teacherList",list);
    }

    //添加讲师方法
    @ApiOperation("添加讲师方法")
    @PostMapping("/addTeacher")
    public ResultData addTeacher(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        return save ? ResultData.ok() : ResultData.error();
    }

    //根据讲师id进行查询
    @ApiOperation("根据讲师id进行查询")
    @PostMapping("/getTeacher/{id}")
    public ResultData getTeacherById(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        return ResultData.ok().data("teacher",teacher);
    }

    //修改讲师方法
    @ApiOperation("修改讲师方法")
    @PostMapping("/updateTeacher")
    public ResultData updateTeacher(@RequestBody Teacher teacher){
        boolean update = teacherService.updateById(teacher);
        return update ? ResultData.ok() : ResultData.error();
    }


}

