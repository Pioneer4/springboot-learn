package name.electricalqzhang.springbootlearn.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import name.electricalqzhang.springbootlearn.model.AjaxResponse;
import name.electricalqzhang.springbootlearn.model.Article;
import name.electricalqzhang.springbootlearn.service.ArticleRestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource
    public ArticleRestService articleRestService;


    //    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article", httpMethod = "POST")
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "author", value = "文章作者", required = true, dataType = "String")
    })*/
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class),
    })
    @PostMapping(value = "/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {

        log.info("saveArticle：{}", article);

        log.info(articleRestService.saveArticle(article));

        return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle：{}", id);
        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);

        log.info("updateArticle：{}", article);
        return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {

        Article article1 = Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article1);
    }
}