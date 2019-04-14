package cn.xlkai.yz.validator;

import cn.xlkai.yz.validator.provider.IProvider;
import cn.xlkai.yz.validator.valid.IValid;

import java.util.List;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description ValidProvider.java
 */
public interface ValidProvider {

    List<IValid> getValids();

    IProvider getProvider();

}
