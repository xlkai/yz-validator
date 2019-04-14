package cn.xlkai.yz.validator.store;

import cn.xlkai.yz.validator.ValidModel;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Kail
 * @version 1.0
 * @date 19-4-14
 * @description ValidStore.java
 */
public interface ValidStore {

    /**
     * 根据字段名获取字段
     *
     * @param fieldName
     * @return
     */
    Field getField(String fieldName) throws NoSuchFieldException;

    /**
     * 获取当前需要验证的对象
     *
     * @param id
     * @return
     */
    List<ValidModel> valids(@Nullable String id);

}
