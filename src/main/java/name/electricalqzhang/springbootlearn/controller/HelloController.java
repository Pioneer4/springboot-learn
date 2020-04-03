package name.electricalqzhang.springbootlearn.controller;

import lombok.extern.slf4j.Slf4j;
import name.electricalqzhang.springbootlearn.model.Article;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping(value = "/hello/{name}", method = GET, params = "name=zhangqin，张沁")
    public String hello(@PathVariable String name) {
        Article article = new Article();
        article.setAuthor(name);

        log.info("Slf4j的测试内容：{}", article.toString());

        return "Hello world, " + article;
    }


    @RequestMapping(value = "/hello/{name}", method = GET)
    public String helloAll(@PathVariable String name) {
        Article article = new Article();
        article.setAuthor(name);

        log.info("大家好{}", name);

        return "Hello world, all guys!";
    }
}
