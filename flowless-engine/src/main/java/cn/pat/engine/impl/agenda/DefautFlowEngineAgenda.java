package cn.pat.engine.impl.agenda;

import cn.pat.engine.impl.util.CommandContext;
import cn.pat.engine.runtime.ProcessInstance;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class DefautFlowEngineAgenda implements FlowEngineAgenda{

    protected CommandContext commandContext;

    protected LinkedList<Runnable> operations = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return  operations.isEmpty();
    }

    @Override
    public Runnable getNextOperation() {
        return operations.poll();
    }

    @Override
    public void planOperation(Runnable operation, ProcessInstance ProcessInstance) {
        // 先直接执行
        operation.run();
    }

    @Override
    public void planContinueProcessOperation(ProcessInstance processInstance) {
        planOperation(new ContinueProcessOperation(this,processInstance),processInstance);
    }

    @Override
    public void planTakeOutgoingSequenceFlowsOperation(ProcessInstance processInstance, boolean evaluateConditions) {
        planOperation(new TakeOutgoingSequenceFlowOperation(this,processInstance,evaluateConditions),processInstance);
    }

    @Override
    public void planEndProcessInstanceOperation(ProcessInstance processInstance) {
        log.debug("process :{} ended!!",processInstance);
    }

    @Override
    public void planTriggerProcessInstanceOperation(ProcessInstance processInstance) {

    }

    @Override
    public void planExecuteInactiveBehaviorsOperation() {

    }
}
