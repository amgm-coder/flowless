package cn.pat.engine.impl.agenda;

import cn.pat.engine.impl.behavior.ActivityBehavior;
import cn.pat.engine.runtime.ProcessInstance;
import cn.pat.model.FlowElement;
import cn.pat.model.FlowNode;
import cn.pat.model.SequenceFlow;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContinueProcessOperation extends AbstractOperation{

    public ContinueProcessOperation(FlowEngineAgenda agenda, ProcessInstance execution) {
        super(agenda, execution);
    }

    @Override
    public void run() {
        FlowElement currentFlowElement = getCurrentFlowElement();
        if (currentFlowElement instanceof FlowNode) {
            continueThroughFlowNode((FlowNode) currentFlowElement);
        } else if (currentFlowElement instanceof SequenceFlow) {
            continueThroughSequenceFlow((SequenceFlow) currentFlowElement);
        }

    }

    private void continueThroughSequenceFlow(SequenceFlow sequenceFlow) {
        FlowNode targetFlowElement = sequenceFlow.getTargetFlowElement();
        execution.setCurrentFlowElement(targetFlowElement);
        if (targetFlowElement instanceof FlowNode) {
            continueThroughFlowNode(targetFlowElement);
        }else {
            agenda.planContinueProcessOperation(execution);
        }
    }

    protected void continueThroughFlowNode(FlowNode flowNode) {
        log.debug("continue through flow node:{}",flowNode);
        ActivityBehavior behavior = (ActivityBehavior) flowNode.getBehavior();
        if (behavior != null) {
            executeActivityBehavior(behavior, flowNode);
        }else {
            agenda.planTakeOutgoingSequenceFlowsOperation(execution,true);
        }
    }

    protected void executeActivityBehavior(ActivityBehavior behavior, FlowNode flowNode) {
        try {
            log.debug("execute ActivityBehavior:{}",behavior);
            behavior.execute(execution);
        } catch (Exception e) {

            log.warn("execute ActivityBehavior:{}",behavior,e);
            throw e;
        }
    }
}
