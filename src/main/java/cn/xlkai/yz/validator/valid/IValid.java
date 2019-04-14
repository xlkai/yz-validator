package cn.xlkai.yz.validator.valid;

import cn.xlkai.yz.validator.ValidModel;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description IValid.java
 */
public interface IValid {

    /**
     * @param value 值
     * @param valid {@link ValidModel}
     * @return true则验证通过，fasle验证不通过
     */
    boolean valid(Object value, ValidModel valid);

    String getMsg(ValidModel valid);
}
