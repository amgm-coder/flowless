package cn.pat.engine;

import cn.pat.engine.repository.ProcessDefinition;
import cn.pat.model.BpmnProcess;

/**
 *  管理以下内容
 *  model - deployment - definition
 *
 * @author pat
 * @date 2021/11/02
 */
public interface RepositoryService {




    ProcessDefinition getProcessDefinition(String processDefinitionId);

    BpmnProcess getBpmnProcess(String processDefinitionId);

}
