package cn.melvin.controller;

import cn.melvin.domain.Book;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Validated
@RestController
public class Validataontroller {

    @GetMapping("/test")
    public String test(@NotBlank(message = "name 不能为空") @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间") String name){
        return "success";
    }

    @GetMapping("/test2")
    public String test2(@Validated Book book){
        return "success";
    }
}
