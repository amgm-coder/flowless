package cn.pat.engine.impl.behavior;

import cn.pat.entity.ProcessInstance;
import cn.pat.model.UserTask;

public class UserTaskActivityBehavior extends ActivityBehavior {

    private UserTask userTask;

    public UserTaskActivityBehavior(UserTask userTask) {
        this.userTask = userTask;
    }

    @Override
    public void execute(ProcessInstance processInstance) {

    }
}
