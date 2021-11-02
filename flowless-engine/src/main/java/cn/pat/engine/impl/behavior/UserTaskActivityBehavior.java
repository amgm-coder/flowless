package cn.pat.engine.impl.behavior;

import cn.pat.engine.runtime.ProcessInstance;
import cn.pat.model.UserTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserTaskActivityBehavior extends ActivityBehavior {

    private UserTask userTask;

    public UserTaskActivityBehavior(UserTask userTask) {
        this.userTask = userTask;
    }

    @Override
    public void execute(ProcessInstance processInstance) {
        log.info("leave user task");
        performOutgoingBehavior(processInstance);
    }


}
