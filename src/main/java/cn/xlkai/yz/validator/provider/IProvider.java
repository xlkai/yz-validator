package cn.xlkai.yz.validator.provider;

import cn.xlkai.yz.validator.store.ValidStore;

public interface IProvider {

    ValidStore get(Class<?> cls);

}
