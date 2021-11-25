package cn.pat.engine.runtime;

import cn.pat.model.FlowElement;

public interface ProcessInstance {

    FlowElement getCurrentFlowElement();

    String getCurrentActivityId();

    void setCurrentFlowElement(FlowElement flowElement);
}
