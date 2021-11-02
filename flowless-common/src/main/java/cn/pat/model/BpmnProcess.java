package cn.pat.model;

import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 流程
 * bpmn中有 bpmnModel 和 process,  BpmnModel可以包含多个process.  现将二者简化成一个
 *
 * @author pat
 * @date 2021/10/25
 */
@EqualsAndHashCode(callSuper = true,exclude = "elementMap")
public class BpmnProcess extends FlowNode{


    private final Map<String,FlowElement> elementMap = new HashMap<>();


    public void addElement(FlowElement flowElement) {
        elementMap.put(flowElement.getId(), flowElement);
    }

    public FlowElement getElementById(String id){
        return elementMap.get(id);
    }

    @SuppressWarnings("unchecked")
    public <T extends FlowElement> List<T> findElementsOfType(Class<T> type){
        return (List<T>) elementMap.values().stream().filter(type::isInstance).collect(Collectors.toList());
    }

    public Collection<FlowElement> getElements() {
        return this.elementMap.values();
    }

    @Override
    public String toString() {
        return "BpmnProcess(id=" + this.getId() + ", name=" + this.getName() + ")";
    }

}
