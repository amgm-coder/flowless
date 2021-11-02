package cn.pat.entity;

import cn.pat.model.FlowElement;
import lombok.Data;

@Data
public class ProcessInstance {

    private String currentActivityId;

    private FlowElement currentFlowElement;


}
