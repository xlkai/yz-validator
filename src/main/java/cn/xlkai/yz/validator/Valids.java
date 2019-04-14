package cn.xlkai.yz.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description Valids.java
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Valids {

    /**
     * 字段简称
     *
     * @return
     */
    String name();

    /**
     * 字段校验
     *
     * @return
     */
    Valid[] value();
}
