package cn.xlkai.yz.validator;

import cn.xlkai.yz.validator.custom.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description Valid.java
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Valid {

    /**
     * id
     *
     * @return
     */
    String[] id() default ValidManager.DEFAULT_NAME;

    /**
     * 字段简称
     *
     * @return
     */
    String name() default "";

    /**
     * 是否为空
     *
     * @return
     */
    boolean nullable() default false;

    /**
     * 最小长度
     *
     * @return
     */
    int min() default 0;

    /**
     * 最大长度
     *
     * @return
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 小数保留位数
     *
     * @return
     */
    int scale() default -1;

    /**
     * 正则校验
     *
     * @return
     */
    String pattern() default "";

    /**
     * 正则校验信息
     *
     * @return
     */
    String patternMsg() default "#{name}校验失败";

    /**
     * 自定义校验规则
     *
     * @return
     */
    Class<? extends Validator>[] custom() default Validator.class;
}
