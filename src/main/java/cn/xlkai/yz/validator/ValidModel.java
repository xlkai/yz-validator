package cn.xlkai.yz.validator;

import cn.xlkai.yz.validator.custom.Validator;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description ValidModel.java
 */
@Setter
@Getter
public class ValidModel {

    private String name;
    private String fieldName;
    private boolean nullable;
    private int min;
    private int max;
    private int scale;
    private String pattern;
    private String patternMsg;
    private Class<? extends Validator> validClass;
}
