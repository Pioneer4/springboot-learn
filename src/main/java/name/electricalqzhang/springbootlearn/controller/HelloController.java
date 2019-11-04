package name.electricalqzhang.springbootlearn.controller;

import lombok.extern.slf4j.Slf4j;
import name.electricalqzhang.springbootlearn.model.Article;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        Article article = new Article();
        article.setAuthor("zhao");

        log.info("Slf4j的测试内容：" + article.toString());

        return "Hello world, " + article;
    }
}
