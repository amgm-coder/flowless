package cn.pat.model.validator;

import cn.pat.model.SequenceFlow;
import org.apache.commons.lang3.ObjectUtils;

public class SequenceFlowValidator implements FlowValidator<SequenceFlow> {

    @Override
    public boolean validate(SequenceFlow element) {
        return ObjectUtils.allNotNull(element.getId(), element.getSourceFlowElement(), element.getTargetFlowElement());
    }

}
