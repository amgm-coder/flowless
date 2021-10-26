package cn.pat.model;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程
 *
 * @author pat
 * @date 2021/10/25
 */
@EqualsAndHashCode(callSuper = true,exclude = "elementMap")
public class Process extends FlowNode{


    private final List<FlowElement> elements = new ArrayList<>();
    private final Map<String,FlowElement> elementMap = new HashMap<>();


    public void addElement(FlowElement flowElement) {
        elements.add(flowElement);
        elementMap.put(flowElement.getId(), flowElement);
    }

    public FlowElement findElementById(String id){
        return elementMap.get(id);
    }

    public List<FlowElement> getElements() {
        return this.elements;
    }

    @Override
    public String toString() {
        return "Process(id=" + this.getId() + ", name=" + this.getName() + ")";
    }

}
