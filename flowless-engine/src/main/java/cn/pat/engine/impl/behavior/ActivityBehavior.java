package cn.pat.engine.impl.behavior;

import cn.pat.entity.ProcessInstance;

public abstract class ActivityBehavior {

    protected abstract void execute(ProcessInstance processInstance);

    public void performOutgoingBehavior(ProcessInstance processInstance) {

    }
}
