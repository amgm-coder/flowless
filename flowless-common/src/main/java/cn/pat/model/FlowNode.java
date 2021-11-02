package cn.pat.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 流程节点
 *
 * @author pat
 * @date 2021/10/25
 */
@EqualsAndHashCode
@Data
public abstract class FlowNode implements FlowElement {
    protected String id;
    protected String name;

    protected Object behavior;
    protected List<SequenceFlow> incomingFlows = new ArrayList<>();
    protected List<SequenceFlow> outgoingFlows = new ArrayList<>();

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addOutgoingSequenceFlow(SequenceFlow sequenceFlow) {
        if (sequenceFlow == null) {
            return;
        }
        if (outgoingFlows == null) {
            outgoingFlows = new ArrayList<>();
            outgoingFlows.add(sequenceFlow);
        } else if (!outgoingFlows.contains(sequenceFlow)) {
            outgoingFlows.add(sequenceFlow);
        }
    }

    public void addIncomingSequenceFlow(SequenceFlow sequenceFlow) {
        if (sequenceFlow == null) {
            return;
        }
        if (incomingFlows == null) {
            incomingFlows = new ArrayList<>();
            incomingFlows.add(sequenceFlow);
        } else if (!incomingFlows.contains(sequenceFlow)) {
            incomingFlows.add(sequenceFlow);
        }
    }

    @Override
    public String toString() {
        return "Node: { id: \"" + id + "\",name: \"" + name + "\"}";
    }

}
