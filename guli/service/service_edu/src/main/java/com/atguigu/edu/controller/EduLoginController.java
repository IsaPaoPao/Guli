package com.atguigu.edu.controller;

import com.atguigu.commonutils.ResultData;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author HTH
 * @create 2022-07-31 21:21
 */
@RestController
@Api(tags = "登录Controller")
@RequestMapping("/eduservice/user")
@CrossOrigin //此注解，解决跨域访问问题
public class EduLoginController {

    //login
    @PostMapping("/login")
    public ResultData login(){
        return ResultData.ok().data("token","saoqi");
    }

    //info
    @GetMapping("/info")
    public ResultData info(){
        return ResultData.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }


}
