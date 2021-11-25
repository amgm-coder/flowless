package cn.pat.model.parser.parse;

import cn.pat.model.BpmnProcess;
import cn.pat.model.FlowElement;
import cn.pat.model.FlowNode;
import cn.pat.model.SequenceFlow;

/**
 * 序列流解析处理程序
 *
 * @author pat
 * @date 2021/10/26
 */
public class SequenceFlowParseHandler implements ParseHandler<SequenceFlow> {

    @Override
    public void executeParse(BpmnProcess process, SequenceFlow flowElement) {
        String sourceRef = flowElement.getSourceRef();
        if (sourceRef != null) {
            FlowElement source = process.getElementById(sourceRef);
            if (source != null) {
                flowElement.setSourceFlowElement((FlowNode) source);
                ((FlowNode) source).addOutgoingSequenceFlow(flowElement);
            }
        }

        String targetRef = flowElement.getTargetRef();
        if (targetRef != null) {
            FlowElement target = process.getElementById(targetRef);
            if (target != null) {
                flowElement.setTargetFlowElement((FlowNode) target);
                ((FlowNode) target).addIncomingSequenceFlow(flowElement);
            }
        }
    }
}
