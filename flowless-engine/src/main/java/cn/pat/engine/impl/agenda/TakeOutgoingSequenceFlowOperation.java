package cn.pat.engine.impl.agenda;

import cn.pat.engine.runtime.ProcessInstance;
import cn.pat.model.FlowElement;
import cn.pat.model.FlowNode;
import cn.pat.model.SequenceFlow;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TakeOutgoingSequenceFlowOperation extends AbstractOperation{

    public TakeOutgoingSequenceFlowOperation(FlowEngineAgenda agenda, ProcessInstance execution, boolean evaluateConditions) {
        super(agenda, execution);
        this.evaluateConditions = evaluateConditions;
    }

    protected boolean evaluateConditions;



    @Override
    public void run() {
        FlowElement currentFlowElement = getCurrentFlowElement();

        if (currentFlowElement instanceof FlowNode) {
            handleFlowNode((FlowNode) currentFlowElement);
        } else if (currentFlowElement instanceof SequenceFlow) {
            handleSequenceFlow((SequenceFlow) currentFlowElement);
        }
    }

    protected void handleSequenceFlow(SequenceFlow sequenceFlow) {
        agenda.planContinueProcessOperation(execution);
    }

    protected void handleFlowNode(FlowNode flowNode) {
        leaveFlowNode(flowNode);
    }

    protected void leaveFlowNode(FlowNode flowNode) {
        log.debug("Leaving flow node {} with id '{}' by following it's {} outgoing sequenceflow",
                flowNode.getClass(), flowNode.getId(), flowNode.getOutgoingFlows().size());

        if (flowNode.getOutgoingFlows()==null ||flowNode.getOutgoingFlows().size() == 0) {
            log.debug("No outgoing sequence flow found for flow node '{}'.", flowNode.getId());
            agenda.planEndProcessInstanceOperation(execution);
        }else if (flowNode.getOutgoingFlows().size() == 1) {
            SequenceFlow sequenceFlow = flowNode.getOutgoingFlows().get(0);
            execution.setCurrentFlowElement(sequenceFlow);
            agenda.planContinueProcessOperation(execution);
        }

    }
}
