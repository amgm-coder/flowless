package cn.pat.engine.impl.agenda;

import cn.pat.engine.impl.util.CommandContext;
import cn.pat.engine.runtime.ProcessInstance;
import cn.pat.model.FlowElement;

public abstract class AbstractOperation implements Runnable {

    protected FlowEngineAgenda agenda;

    protected CommandContext commandContext;

    protected ProcessInstance execution;

    public AbstractOperation(FlowEngineAgenda agenda, ProcessInstance execution) {
        this.agenda = agenda;
        this.execution = execution;
    }

    protected FlowElement getCurrentFlowElement() {
        FlowElement currentFlowElement = execution.getCurrentFlowElement();
        if (currentFlowElement == null) {
            String currentActivityId = execution.getCurrentActivityId();
        }
        return currentFlowElement;
    }
}
