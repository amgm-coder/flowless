package cn.pat.engine.impl.behavior;

import cn.pat.engine.runtime.ProcessInstance;

public abstract class ActivityBehavior {

    public abstract void execute(ProcessInstance processInstance);

    public void performOutgoingBehavior(ProcessInstance processInstance) {

    }
}
