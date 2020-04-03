package name.electricalqzhang.springbootlearn.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description:
 * @Date: Created in 2019/5/20
 * @Author: cdpengmingchao
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DocUploadDTO {
    /** 分类名称*/
    private String catePath;
    /** 分类名称*/
    private String title;
    /** 分类名称*/
    private String contentHtml;
    private String startTime;
    private String endTime;
}
