package cn.pat.design;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * 流程
 *
 * @author pat
 * @date 2021/10/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Process extends FlowNode{


    private List<FlowElement> elements;
    private Map<String,FlowElement> elementMap;

}
