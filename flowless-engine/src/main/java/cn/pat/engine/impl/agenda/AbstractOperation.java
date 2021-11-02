package cn.pat.engine.impl.agenda;

import cn.pat.entity.ProcessInstance;

public abstract class AbstractOperation implements Runnable{

    protected FlowEngineAgenda agenda;

    protected ProcessInstance execution;

    public AbstractOperation(FlowEngineAgenda agenda, ProcessInstance execution) {
        this.agenda = agenda;
        this.execution = execution;
    }
}
