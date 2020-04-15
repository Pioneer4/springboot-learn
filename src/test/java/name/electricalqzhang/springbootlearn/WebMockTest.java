//package name.electricalqzhang.springbootlearn;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import name.electricalqzhang.springbootlearn.controller.ArticleRestController;
//import name.electricalqzhang.springbootlearn.model.Article;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpMethod;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ArticleRestController.class)
//public class WebMockTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ArticleRestService service;
//
//    @Test
//    public void saveArticle() throws Exception {
//        String article = "{\n" +
//                "    \"id\": 1,\n" +
//                "    \"author\": \"zimug\",\n" +
//                "    \"title\": \"手摸手教你开发spring boot\",\n" +
//                "    \"content\": \"c\",\n" +
//                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
//                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
//                "}";
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Article articleObj = objectMapper.readValue(article,Article.class);
//
//        //打桩
//        when(articleRestService.saveArticle(articleObj)).thenReturn("ok");
//
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
//                .contentType("application/json").content(article))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
//                .andDo(print())
//                .andReturn();
//
//        log.info(result.getResponse().getContentAsString());
//
//    }
//}
