package cn.pat.design;

/**
 * 序列流
 *
 * @author pat
 * @date 2021/10/25
 */
public class SequenceFlow implements FlowElement{
    /**
     * 源
     */
    private FlowNode source;
    /**
     * 目标
     */
    private FlowNode target;

    /**
     * 条件
     */
    private String condition;
}
