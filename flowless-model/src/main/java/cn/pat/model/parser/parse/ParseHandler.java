package cn.pat.model.parser.parse;

import cn.pat.model.BpmnProcess;
import cn.pat.model.FlowElement;

/**
 * 解析处理程序
 *
 * @author pat
 * @date 2021/10/26
 */
public interface ParseHandler<T extends FlowElement> {
    /**
     * 执行解析
     *
     * @param process 流程
     * @param flowElement 流元素
     */
    void executeParse(BpmnProcess process, T flowElement);



}
