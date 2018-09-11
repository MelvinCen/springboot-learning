package cn.melvin.controller;

import cn.melvin.domain.Author;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class ThymeleafController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        // 设置属性
        view.addObject("title", "我的第一个WEB页面");
        view.addObject("desc", "欢迎进入Melvin-web 系统");

        Author author = new Author();
        author.setName("Melvin");
        author.setAge(25);
        author.setEmail("niubility@gmail.com");
        view.addObject("author", author);
        return view;
    }

    @GetMapping("/index1")
    public String index1(HttpServletRequest request){
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "我的第一个WEB页面");
        request.setAttribute("desc", "欢迎进入Melvin-web 系统");

        Author author = new Author();
        author.setName("Melvin");
        author.setAge(25);
        author.setEmail("niubility@gmail.com");
        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }
}
