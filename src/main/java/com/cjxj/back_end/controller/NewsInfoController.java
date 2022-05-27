package com.cjxj.back_end.controller;

import com.alibaba.fastjson.JSONArray;
import com.cjxj.back_end.entity.Result;
import com.cjxj.back_end.util.NewsInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-05-23
 */
@RestController
@RequestMapping("/news")
public class NewsInfoController {

    @GetMapping("getInfo")
    public Result getNewInfo(){
        Result result = new Result();
        try {
            String str = NewsInfo.getInfo("重庆");
            result.setCode(200);
            result.setData(JSONArray.parse(str));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(400);
            result.setData("获取信息错误！");
            return result;
        }
    }
}
