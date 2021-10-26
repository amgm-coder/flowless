package cn.pat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 序列流
 *
 * @author pat
 * @date 2021/10/25
 */
@Data
public class SequenceFlow implements FlowElement{

    private String id;
    private String name;

    /**
     * 源节点id
     */
    private String sourceRef;
    /**
     * 目标节点id
     */
    private String targetRef;

    /**
     * 源
     */
    @JsonIgnore
    private FlowNode sourceFlowElement;
    /**
     * 目标
     */
    @JsonIgnore
    private FlowNode targetFlowElement;

    /**
     * 条件
     */
    private String conditionExpression;
}
