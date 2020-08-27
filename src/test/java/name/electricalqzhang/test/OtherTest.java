package name.electricalqzhang.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import name.electricalqzhang.springbootlearn.TaskStatus;
import name.electricalqzhang.springbootlearn.model.Article;
import name.electricalqzhang.springbootlearn.model.DocUploadDTO;
import name.electricalqzhang.springbootlearn.model.FlowParam;
import name.electricalqzhang.springbootlearn.model.Reader;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.util.collections.ListUtil;
import org.springframework.beans.BeanUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class OtherTest {
    public enum ValueType {FIELD, VALUE, SQL}

    ;

    @Test
    public void testFile() {

        File file = new File("D:\\prj\\OpenKnowledge\\导入模板.txt");
        if (!file.exists()) {
            return;
        }
        System.out.println("文档存在，类型为：" + getFileType(file.getName()));
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
            BufferedReader reader = new BufferedReader(isr);
            List<DocUploadDTO> successList = Lists.newArrayList();
            String lineTxt = null;
            while ((lineTxt = reader.readLine()) != null) {
                if (StringUtils.isBlank(lineTxt)) {
                    continue;
                }
                DocUploadDTO dto = new DocUploadDTO();
                String[] split = lineTxt.split("\\t");
                for (String str : split) {
                    if (StringUtils.isBlank(str)) {
                        continue;
                    }
                    System.out.println(str);
                }
                System.out.println("--------------------");
                if (split.length == 5) {
                    dto.setCatePath(split[0]);
                    dto.setTitle(split[1]);
                    dto.setContentHtml(split[2]);
                    dto.setStartTime(split[3]);
                    dto.setEndTime(split[4]);
                    successList.add(dto);
                }
            }

            System.out.println(JSON.toJSON(successList));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileType(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()).toLowerCase();
    }

    @Test
    public void testClass() throws IllegalAccessException, InstantiationException {

        classMethod(DocUploadDTO.class);
    }

    public <T> void classMethod(Class<T> clazz) {
        try {
            String str = "zhangqin";
            T t = clazz.newInstance();
            Method setCatePath = clazz.getDeclaredMethod("setCatePath", String.class);
            setCatePath.setAccessible(true);
            setCatePath.invoke(t, "zhang");
            System.out.println(JSON.toJSONString(t));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSet() {
        Set<String> set = Sets.newHashSet();
        set.add("zhangqin");
        set.add("wuyuman");
        System.out.println(set);
    }

    @Test
    public void parseSessionId() {
        String classfies = "[{\"classify\":\"如何取消订单\",\"count\":1,\"sessionId\":\"4cab139a2aab3ff9696c49cdc306cad9\",\"terminal\":\"IM\"},{\"classify\":\"保修返修及退换货政策\",\"count\":1,\"sessionId\":\"4cab139a2aab3ff9696c49cdc306cad9\",\"terminal\":\"IM\"}]";
        String classfies2 = "[{\"classify\":\"商品检索\",\"count\":2,\"sessionId\":\"e5ff6b06-b179-4dd9-b5fb-c1db3e30b94e\",\"terminal\":\"IM\"},{\"classify\":\"保修返修及退换货政策\",\"count\":2,\"sessionId\":\"e22b34a8-29d8-4fb2-b869-4063ed574cc8\",\"terminal\":\"IM\"},{\"classify\":\"预售订单\",\"count\":1,\"sessionId\":\"b78f4ec8-8bf2-41ca-ad8d-32c3e578b84c\",\"terminal\":\"IM\"},{\"classify\":\"返修退换货拆包装\",\"count\":1,\"sessionId\":\"f83d1f3e-5537-4a62-9330-4a79d581398b\",\"terminal\":\"IM\"},{\"classify\":\"生鲜\",\"count\":1,\"sessionId\":\"7e631fe9-d314-49df-ac24-52c0920a335e\",\"terminal\":\"IM\"},{\"classify\":\"外包装\",\"count\":1,\"sessionId\":\"85892599-3dcd-4515-81bb-812b7f1ee14d\",\"terminal\":\"IM\"},{\"classify\":\"商品价格咨询\",\"count\":1,\"sessionId\":\"7dd4cff5-6f78-4ad4-9c53-eba695bff5b8\",\"terminal\":\"IM\"},{\"classify\":\"发错货\",\"count\":1,\"sessionId\":\"3f179831-60c9-4eb9-a994-e66a0aa86a78\",\"terminal\":\"IM\"},{\"classify\":\"包装清单\",\"count\":1,\"sessionId\":\"b8601c92-180e-4ac3-9dd6-ef66e673ccb6\",\"terminal\":\"IM\"}]";
        System.out.println(classfies2);

        String regex = "},";

        String[] split = classfies2.split(regex);
        for (String str : split) {
            String substring = str.substring(str.indexOf("sessionId") + "sessionId\":".length(), str.indexOf(",\"terminal"));
            String result = substring.replaceAll("-", "");
            System.out.println(result);
        }
    }

    @Test
    public void jackson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Reader reader = new Reader("Linus", 58);
        Article article = new Article();
        List readers = Lists.newArrayList();
        readers.add(reader);
        article.setReader(readers);

        String str = objectMapper.writeValueAsString(article);
        System.out.println(str);
    }

    @Test
    public void testUUID() {
        String str = "9cb26a0cbf2fa77167f5ef3ecddbb857,";
        byte[] bytes = str.getBytes();
        System.out.println(bytes.length);
    }

    @Test
    public void testDownloadTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String downloadStart = "2020-04-16 11:37:26";
        String downloadEnd = "2020-04-16 11:41:52";

        Date startDate = sdf.parse(downloadStart);
        Date endDate = sdf.parse(downloadEnd);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf2.format(startDate));

        System.out.println(endDate.getTime() - startDate.getTime());

        Calendar cal = Calendar.getInstance();
        System.out.println(sdf.format(cal.getTime()));
        cal.add(Calendar.HOUR_OF_DAY, 24);
        System.out.println(sdf.format(cal.getTime()));
    }

    @Test
    public void testJson() {
        Person1 person1 = new Person1();
        person1.setAge(10);
        person1.setName("Guo");

        System.out.println(JSON.toJSONString(person1));

//        Person2 person2 = JSON.parseObject(JSON.toJSONString(person1), Person2.class);

        Person2 person2 = new Person2();
        BeanUtils.copyProperties(person1, person2);

        System.out.println(JSON.toJSONString(person2));
    }

    public static class Person1 {
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Person2 {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public void inspect(List<? extends Object> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    @Test
    public void testGeneric() {
        List strs = Lists.newArrayList();
        strs.add("1");
        strs.add(12);
        inspect(strs);
    }


    public <T> void inspect2(List<T> list) {
        for (T obj : list) {
            System.out.println(obj);
            System.out.println(obj.getClass().getName());
        }
    }

    @Test
    public void testGeneric2() {
        List strs = Lists.newArrayList();
        strs.add("1");
        strs.add(12);
        inspect2(strs);
        Map<String, String> map = Maps.newHashMap("zhang", "25");
        map.putIfAbsent("zhang", "26");
        System.out.println(map);
    }

    @Test
    public void testStr() {
        String str = null;
        System.out.println("name_" + str);
        String.valueOf(1);
    }


    @Test
    public void splitOssUrl() {
//        String ossUrl = "http://storage.jd.local/hot-stat/hot_scene/test";
        String ossUrl = "http://storage.jd.com/hot-stat/hot_word/strData";

        if (StringUtils.isBlank(ossUrl)) {
            return;
        }

        if (ossUrl.length() < "http://storage.jd.com/".length()) {
            return;
        }

        String str = ossUrl.substring("http://storage.jd.com/".length());
        String bucket = str.substring(0, str.indexOf("/"));
        String objectKey = str.substring(str.indexOf("/") + 1);

        System.out.println(bucket);
        System.out.println(objectKey);

    }

    @Test
    public void testSet2Str() {
        Set<String> set = new HashSet<>();
        set.add("ad312e3d83d5dd6e28b2d0a9a949f175");
        set.add("ad312-e3d83-d5dd6e28b2d0a9a949f175");
        set.add("78a6fd143ace59febceb498ad67a858b, b20f2f89f04e62b52630abd25ee1d2e0, d33bee2aaee4b817f73bfb5121790848");
        System.out.println(set);
        System.out.println(set.toString().replaceAll("[\\[\\]\\s]", ""));
    }

    @Test
    public void testFlowParam() {
        Reader reader = new Reader("Linus", 58);
        Article article = new Article();
        List readers = Lists.newArrayList();
        readers.add(reader);
        article.setReader(readers);

        FlowParam flowParam = new FlowParam("141", JSON.toJSONString(article));

        String str = JSON.toJSONString(flowParam);
        System.out.println(str);

        FlowParam flowParam1 = JSON.parseObject(str, FlowParam.class);
        Article article1 = JSON.parseObject(flowParam1.getFlowParam(), article.getClass());
        System.out.println(JSON.toJSONString(article1));
        System.out.println(JSON.toJSONString(article));
    }

    @Test
    public void testNewArrayList() {
        Reader designer = new Reader("Linus", 58);
        Reader coder = new Reader("Gosling", 64);
        
        System.out.println(JSON.toJSONString(designer));

        List<Reader> list = Lists.newArrayList(designer);
        System.out.println(JSON.toJSONString(list));

        System.out.println("---------------------");

        List<Reader> masters = Lists.newArrayList();
        masters.add(designer);
        masters.add(coder);
        System.out.println(JSON.toJSONString(masters));

        for (int i=0; i<masters.size(); i++) {
            Reader zhangqin = masters.get(i);
            zhangqin.setName("zhangqin");
        }
        System.out.println(JSON.toJSONString(masters));
    }

    @Test
    public void testSubstring() {
        Set<String> set = new HashSet<>();
        set.add("ad312e3d83d5dd6e28b2d0a9a949f175");
        set.add("ad312-e3d83-d5dd6e28b2d0a9a949f175");
        set.add("78a6fd143ace59febceb498ad67a858b, b20f2f89f04e62b52630abd25ee1d2e0, d33bee2aaee4b817f73bfb5121790848");
        set.add(null);
        set.add("");

        String[] array = set.toArray(new String[set.size()]);

        System.out.println(Arrays.toString(array));

        StringBuilder sb = new StringBuilder();
        Boolean seprate = false;
        for (String str : array) {
            if (StringUtils.isNotBlank(str)) {
                if (seprate) {
                    sb.append(",").append(str);
                } else {
                    seprate = true;
                    sb.append(str);
                }
            }
        }

        System.out.println(String.join(",", array));

        System.out.println(sb.toString());

    }

    @Test
    public void testStringBuilder() {
        int sessionIdSize = 100;

        Set<String> set = new HashSet<>();
        set.add("ad312e3d83d5dd6e28b2d0a9a949f175");
        set.add("ad312-e3d83-d5dd6e28b2d0a9a949f175");
        set.add("78a6fd143ace59febceb498ad67a858b, b20f2f89f04e62b52630abd25ee1d2e0, d33bee2aaee4b817f73bfb5121790848");
        set.add(null);
        set.add("");
        set.add("   ");


        String[] array = set.toArray(new String[set.size()]);
        String sessionIdsStr = String.join(",", array);

        sessionIdsStr = sessionIdsStr + ",null, , ,,,, ,,, , , , ,         ,";

        System.out.println("数据源：\r\n" + sessionIdsStr);
        System.out.println("结果集size = " + sessionIdSize);

        // 顺序截取单个sessionId，进行判空和保存操作，最多保存数量为sessionIdSize
        int count = 0;
        int startCursor = -1;
        int endCursor = sessionIdsStr.indexOf(",");

        StringBuilder result = new StringBuilder();
        Boolean seprate = false;

        while (count<sessionIdSize && endCursor!=-1) {
            String sessionId = sessionIdsStr.substring(startCursor+1, endCursor);
            if (StringUtils.isNotBlank(sessionId) && !"null".equals(sessionId)) {
                // 保存非空sessionId
                if (seprate) {
                    result.append(",").append(sessionId);
                } else {
                    seprate = true;
                    result.append(sessionId);
                }
                // 计数
                count++;
            }
            // 调整游标位置
            startCursor = endCursor;
            endCursor = sessionIdsStr.indexOf(",", startCursor+1);
        }

        /**
         * 处理特殊情况:
         * 1. 数据源只有单个sessionId;
         * 2. 结果集中的数量不满足数量要求sessionIdSize，需要截取数据源中的最后一个sessionId
         */
        if (count < sessionIdSize) {
            String sessionId = sessionIdsStr.substring(startCursor + 1);
            if (StringUtils.isNotBlank(sessionId) && !"null".equals(sessionId)) {
                // 保存非空sessionId
                if (seprate) {
                    result.append(",").append(sessionId);
                } else {
                    seprate = true;
                    result.append(sessionId);
                }
            }
        }

        System.out.println("结果集：\r\n" + result.toString());
    }

    @Test
    public void testJsonObject() {
        Reader reader = new Reader("Linus", 58);
        Article article = new Article();
        List readers = Lists.newArrayList();
        readers.add(reader);
        article.setReader(readers);
        article.setAuthor("bird");

        String jsonString = JSON.toJSONString(article);
        System.out.println(jsonString);

        JSONObject parseObject = JSON.parseObject(jsonString);
        System.out.println(JSON.toJSONString(parseObject));

        Object reader1 = parseObject.get("reader");
        System.out.println(reader1.toString());
    }

    @Test
    public void testListToString() {
        List<String> list = new ArrayList();
        list.add("ad312e3d83d5dd6e28b2d0a9a949f175");
        list.add("ad312-e3d83-d5dd6e28b2d0a9a949f175");
        list.add("78a6fd143ace59febceb498ad67a858b, b20f2f89f04e62b52630abd25ee1d2e0, d33bee2aaee4b817f73bfb5121790848");
        System.out.println(list);
    }

    @Test
    public void testLongtoInteger() {
        Long numLong = new Long(123);
        Integer numInteger = numLong.intValue();
        System.out.println(numInteger);
    }

    @Test
    public void printFail() {
        System.out.println(TaskStatus.FAIL.name());
    }

    @Test
    public void testCal() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        Date date = null;
        try {
            date = sdf.parse("2019-01-01 00:05:22");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        if (cal.get(Calendar.MINUTE) >= 30) {
            cal.set(Calendar.MINUTE, 30);
        } else {
            cal.set(Calendar.MINUTE, 0);
        }

        Date endTime = cal.getTime();

        cal.add(Calendar.MINUTE, -30);
        cal.add(Calendar.MINUTE, 1);
        Date startTime = cal.getTime();

        System.out.println(sdf.format(startTime));
        System.out.println(sdf.format(endTime));
    }

    @Test
    public void testGetSysProperties() {
        System.getProperties().list(System.out);
    }
}
