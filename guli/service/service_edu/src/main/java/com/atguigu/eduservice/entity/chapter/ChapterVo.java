package com.atguigu.eduservice.entity.chapter;

import lombok.Data;

import java.util.List;

/**
 * @author HTH
 * @create 2022-10-06 16:19
 */
@Data
public class ChapterVo {

    private String id;
    private String title;
    //章节中的小结
    private List<VideoVo> children;

}
