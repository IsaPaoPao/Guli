package com.atguigu.commonutils;

public enum ResultCode {

    SUCCESS(20000,"成功",true),
    ERROR(20001,"失败",false);

    private Integer code;
    private String desc;
    private Boolean success;

    ResultCode(Integer code, String desc, Boolean success) {
        this.code = code;
        this.desc = desc;
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static ResultCode valueOfEnum(Object code){
        ResultCode[] iss = values();
        for (ResultCode cs : iss) {
            if (code instanceof String){
                if (cs.getCode().equals(code)){
                    return cs;
                }
            }else if (code instanceof Integer){
                if (cs.getCode() == code){
                    return cs;
                }
            }
        }
        return null;
    }
}
