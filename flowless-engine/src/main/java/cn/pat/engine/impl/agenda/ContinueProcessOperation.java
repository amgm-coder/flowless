package cn.pat.engine.impl.agenda;

import cn.pat.entity.ProcessInstance;
import cn.pat.model.FlowElement;
import cn.pat.model.FlowNode;

public class ContinueProcessOperation extends AbstractOperation{

    public ContinueProcessOperation(FlowEngineAgenda agenda, ProcessInstance execution) {
        super(agenda, execution);
    }

    @Override
    public void run() {
        FlowElement currentFlowElement = execution.getCurrentFlowElement();
        if (currentFlowElement == null) {
            String currentActivityId = execution.getCurrentActivityId();
        }
        if (currentFlowElement instanceof FlowNode) {
            continueThroughFlowNode((FlowNode) currentFlowElement);
        }

    }

    protected void continueThroughFlowNode(FlowNode flowNode) {

    }
}
