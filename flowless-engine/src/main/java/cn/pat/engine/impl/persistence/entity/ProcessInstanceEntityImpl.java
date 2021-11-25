package cn.pat.engine.impl.persistence.entity;

import cn.pat.engine.impl.cfg.ProcessEngineConfiguration;
import cn.pat.engine.runtime.ProcessInstance;
import cn.pat.model.FlowElement;
import lombok.Data;

import java.util.Date;

@Data
public class ProcessInstanceEntityImpl implements ProcessInstance {

    protected String id;
    /**
     * The tenant identifier (if any)
     */
    protected String tenantId = ProcessEngineConfiguration.NO_TENANT_ID;

    protected String name;

    //    -------- state  --------

    protected FlowElement currentFlowElement;

    protected boolean isEnded;

    protected Date endTime;


    //    -------------------------

    /**
     * Persisted reference to the processDefinition.
     */
    protected String processDefinitionId;

    /**
     * Persisted reference to the process definition key.
     */
    protected String processDefinitionKey;

    /**
     * Persisted reference to the process definition name.
     */
    protected String processDefinitionName;

    /**
     * Persisted reference to the current position in the diagram within the definition.
     */
    protected String activityId;

    /**
     * The name of the current activity position
     */
    protected String activityName;


    @Override
    public String getCurrentActivityId() {
        return activityId;
    }

    @Override
    public void setCurrentFlowElement(FlowElement currentFlowElement) {
        this.currentFlowElement = currentFlowElement;
        if (currentFlowElement != null) {
            activityId = currentFlowElement.getId();
        } else {
            activityId = null;
        }
    }

}
