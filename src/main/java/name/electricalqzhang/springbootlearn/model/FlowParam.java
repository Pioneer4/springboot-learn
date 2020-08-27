package name.electricalqzhang.springbootlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowParam {

    private String flowId;
    private String flowParam;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowParam() {
        return flowParam;
    }

    public void setFlowParam(String flowParam) {
        this.flowParam = flowParam;
    }
}
