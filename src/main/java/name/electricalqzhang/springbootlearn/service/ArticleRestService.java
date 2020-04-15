package name.electricalqzhang.springbootlearn.service;

import lombok.extern.slf4j.Slf4j;
import name.electricalqzhang.springbootlearn.model.AjaxResponse;
import name.electricalqzhang.springbootlearn.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class ArticleRestService {
    public String saveArticle(Article article) {
        log.info("saveArticle：{}",article);
        return  "测试";
    }
}
