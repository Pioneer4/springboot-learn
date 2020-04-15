package name.electricalqzhang.test;

import com.alibaba.fastjson.JSON;
import name.electricalqzhang.springbootlearn.model.DocUploadDTO;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

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

}
