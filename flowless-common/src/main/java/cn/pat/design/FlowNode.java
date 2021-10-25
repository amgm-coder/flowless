package cn.pat.design;

import lombok.Getter;
import lombok.Setter;

/**
 * 流程节点
 *
 * @author pat
 * @date 2021/10/25
 */
@Getter
@Setter
public abstract class FlowNode implements FlowElement{
    private String id;
    private String name;
}
