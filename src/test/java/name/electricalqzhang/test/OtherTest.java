package name.electricalqzhang.test;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import name.electricalqzhang.springbootlearn.model.DocUploadDTO;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.json.JsonbTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class OtherTest {
    public enum ValueType {FIELD,VALUE,SQL};

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

    public void testExcel() {

    }
}
