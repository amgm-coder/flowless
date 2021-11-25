package cn.pat.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 流元素
 *
 * @author pat
 * @date 2021/10/25
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "stencil")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "StartEvent", value = StartEvent.class),
        @JsonSubTypes.Type(name = "EndEvent", value = EndEvent.class),
        @JsonSubTypes.Type(name = "UserTask", value = UserTask.class),
        @JsonSubTypes.Type(name = "SequenceFlow", value = SequenceFlow.class),
})
public interface FlowElement {

    String getId();

}
