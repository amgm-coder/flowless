package cn.pat.engine.impl.agenda;

import cn.pat.entity.ProcessInstance;

public interface FlowEngineAgenda {
    /**
     * Returns whether there currently are operations planned on the agenda.
     */
    boolean isEmpty();

    /**
     * Get next operation from agenda and remove operation from the queue.
     *
     * @return next operation from the queue
     * @throws {@link  todo} in the case when agenda is empty
     */
    Runnable getNextOperation();


    void planOperation(Runnable operation, ProcessInstance ProcessInstance);

    void planContinueProcessOperation(ProcessInstance processInstance);

    void planTakeOutgoingSequenceFlowsOperation(ProcessInstance processInstance, boolean evaluateConditions);

    void planEndprocessInstanceOperation(ProcessInstance processInstance);

    void planTriggerprocessInstanceOperation(ProcessInstance processInstance);

    void planExecuteInactiveBehaviorsOperation();

}
