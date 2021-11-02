package cn.pat.engine.impl.agenda;

import cn.pat.entity.ProcessInstance;

import java.util.LinkedList;
import java.util.List;

public class DefautFlowEngineAgenda implements FlowEngineAgenda{

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
        ;
    }

    @Override
    public void planTakeOutgoingSequenceFlowsOperation(ProcessInstance processInstance, boolean evaluateConditions) {

    }

    @Override
    public void planEndprocessInstanceOperation(ProcessInstance processInstance) {

    }

    @Override
    public void planTriggerprocessInstanceOperation(ProcessInstance processInstance) {

    }

    @Override
    public void planExecuteInactiveBehaviorsOperation() {

    }
}
