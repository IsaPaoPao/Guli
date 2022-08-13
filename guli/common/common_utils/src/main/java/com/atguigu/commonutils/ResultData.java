package com.atguigu.commonutils;


import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
public class ResultData<T> {

    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();


    private ResultData(){

    }

    //成功静态方法
    public static ResultData ok(){
        ResultData resultData = new ResultData();
        resultData.setCode(ResultCode.SUCCESS.getCode());
        resultData.setSuccess(ResultCode.SUCCESS.getSuccess());
        resultData.setMessage(ResultCode.SUCCESS.getDesc());
        return resultData;
    }

    //失败静态方法
    public static ResultData error(){
        ResultData resultData = new ResultData();
        resultData.setCode(ResultCode.ERROR.getCode());
        resultData.setSuccess(ResultCode.ERROR.getSuccess());
        resultData.setMessage(ResultCode.ERROR.getDesc());
        return resultData;
    }

    public ResultData success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultData message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultData code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultData data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultData data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
