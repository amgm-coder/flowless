package cn.pat.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 缺少需要的属性异常
 *
 * @author pat
 * @date 2021/10/26
 */
@Data
@AllArgsConstructor
public class RequiredPropertyMissingException extends RuntimeException {
    private String property;
}
