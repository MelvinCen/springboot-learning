package cn.melvin.controller;

import cn.melvin.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/test")
    public String test(Integer num){
        if (num == null) {
            throw new CustomException(400,"参数num不能为空");
        }
        int i = 10 / num;
        return "result: "+i;
    }
}
