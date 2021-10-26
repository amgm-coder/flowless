package cn.pat.model.validator;

import cn.pat.model.FlowElement;

/**
 * 流和验证器
 *
 * @author pat
 * @date 2021/10/26
 */
public interface FlowValidator<T extends FlowElement> {

    /**
     * 验证
     *
     * @param element 初步的
     * @return boolean
     */
    boolean validate(T element);
}
