package cn.xlkai.yz.validator.custom;

import cn.xlkai.yz.validator.ValidException;
import cn.xlkai.yz.validator.ValidModel;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-15
 * @description Valid.java
 */
public interface Validator<T> {

    /**
     * 自定义校验
     *
     * @param data  校验的对象
     * @param value 字段值
     * @param valid {@link ValidModel}
     * @throws ValidException
     */
    void valid(T data, Object value, ValidModel valid) throws ValidException;

}
