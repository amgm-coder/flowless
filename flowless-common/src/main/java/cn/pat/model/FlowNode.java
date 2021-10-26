package cn.pat.model;

import lombok.EqualsAndHashCode;

/**
 * 流程节点
 *
 * @author pat
 * @date 2021/10/25
 */
@EqualsAndHashCode
public abstract class FlowNode implements FlowElement{
    private String id;
    private String name;

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
