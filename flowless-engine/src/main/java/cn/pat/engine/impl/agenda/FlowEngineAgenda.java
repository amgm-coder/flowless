package cn.pat.engine.impl.agenda;

import cn.pat.engine.runtime.ProcessInstance;

public interface FlowEngineAgenda {
    /**
     * Returns whether there currently are operations planned on the agenda.
     */
    boolean isEmpty();

    /**
     * Get next operation from agenda and remove operation from the queue.
     *
     * @return next operation from the queue
     * @throws TODO in the case when agenda is empty
     */
    Runnable getNextOperation();


    void planOperation(Runnable operation, ProcessInstance ProcessInstance);

    void planContinueProcessOperation(ProcessInstance processInstance);

    void planTakeOutgoingSequenceFlowsOperation(ProcessInstance processInstance, boolean evaluateConditions);

    void planEndProcessInstanceOperation(ProcessInstance processInstance);

    void planTriggerProcessInstanceOperation(ProcessInstance processInstance);

    void planExecuteInactiveBehaviorsOperation();

}
