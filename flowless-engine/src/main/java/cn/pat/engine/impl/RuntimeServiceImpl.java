package cn.pat.engine.impl;

import cn.pat.engine.RuntimeService;
import cn.pat.engine.impl.agenda.DefaultFlowEngineAgenda;
import cn.pat.engine.impl.agenda.FlowEngineAgenda;
import cn.pat.engine.impl.persistence.entity.ProcessInstanceEntityImpl;
import cn.pat.engine.runtime.ProcessInstance;
import cn.pat.model.BpmnProcess;
import cn.pat.model.StartEvent;

import java.util.List;

public class RuntimeServiceImpl implements RuntimeService {

    FlowEngineAgenda agenda = new DefaultFlowEngineAgenda();


    public ProcessInstance startProcessInstance(BpmnProcess bpmnProcess) {

        ProcessInstanceEntityImpl processInstanceEntity = new ProcessInstanceEntityImpl();
        processInstanceEntity.setId("");
        processInstanceEntity.setName(bpmnProcess.getName());
        List<StartEvent> startEvents = bpmnProcess.findElementsOfType(StartEvent.class);
        if (startEvents.isEmpty()) {
            throw new RuntimeException("No StartEvent");
        }
        if (startEvents.size() != 1) {
            throw new RuntimeException("Require 1 StartEvent");

        }
        processInstanceEntity.setCurrentFlowElement(startEvents.get(0));

        agenda.planContinueProcessOperation(processInstanceEntity);

        return processInstanceEntity;
    }

}
